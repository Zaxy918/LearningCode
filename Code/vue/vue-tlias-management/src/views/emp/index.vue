<script setup>

import { onMounted, ref, watch } from "vue";
import { queryPageApi, addEmpApi, queryByIdApi, updateEmpApi, deleteEmpApi } from '@/api/emp';
import { queryAllApi as queryAllDeptApi } from '@/api/dept';
import { ElMessage, ElMessageBox } from "element-plus";

const searchEmp = ref({
  name: '',
  gender: '',
  date: '',
  begin: '',
  end: ''
})
const page = ref(1);
const pageSize = ref(10);
const background = ref(true);
const total = ref(0);
const empList = ref([]);
const selectedEmps = ref([]);
const jobs = ref([
  { label: 'HeadTeacher', value: 1 },
  { label: 'Lecturer', value: 2 },
  { label: 'EmpHeader', value: 3 },
  { label: 'ResearchHeader', value: 4 },
  { label: 'Counselor', value: 5 },
  { label: 'Other', value: 6 }
]);

const tolen = JSON.parse(localStorage.getItem('loginUser'))?.token;

const rules = ref({
  username: [
    { required: true, message: 'Enter a username', trigger: 'blur' },
    { min: 2, max: 20, message: 'Usrname length should be in 2 to 20', trigger: 'blur' }
  ],
  name: [
    { required: true, message: 'Enter a name', trigger: 'blur' },
    { min: 2, max: 10, message: 'Name length should be in 2 to 10', trigger: 'blur' }
  ],
  gender: [
    { required: true, message: 'Please select a gender', trigger: 'change' }
  ],
  phone: [
    { required: true, message: 'Enter a phone number', trigger: 'blur' },
    { pattern: /^1[3-9]\d{9}$/, message: 'Enter a valid phone number', trigger: 'blur' }
  ]
});
const depts = ref([]);
const search = async () => {
  const res = await queryPageApi(
    searchEmp.value.name,
    searchEmp.value.gender,
    searchEmp.value.begin,
    searchEmp.value.end,
    page.value,
    pageSize.value
  );

  if (res.code) {
    empList.value = res.data.rows;
    total.value = res.data.total;
  }
};

const clear = () => {
  searchEmp.value = {
    name: '',
    gender: '',
    date: [],
    begin: '',
    end: ''
  };
  search();
};

const addEmp = () => {
  employee.value = {
    username: '',
    name: '',
    gender: '',
    phone: '',
    job: '',
    salary: '',
    deptId: '',
    entryDate: '',
    image: '',
    exprList: []
  };
  if (employeeForm.value)
    employeeForm.value.resetFields();
  dialogVisible.value = true;
  dialogTitle.value = "Add Employee";
};

const handleSizeChange = (newSize) => {
  search();
};
const handleCurrentChange = (newPage) => {
  search();
};

watch(() => searchEmp.value.date, (newDate) => {
  if (newDate && newDate.length === 2) {
    searchEmp.value.begin = newDate[0];
    searchEmp.value.end = newDate[1];
  } else {
    searchEmp.value.begin = '';
    searchEmp.value.end = '';
  }
});
//新增/修改表单
const employee = ref({
  username: '',
  name: '',
  gender: '',
  phone: '',
  job: '',
  salary: '',
  deptId: '',
  entryDate: '',
  image: '',
  exprList: []
})

// 控制弹窗
const dialogVisible = ref(false)
const dialogTitle = ref('Add Employee')

//文件上传
// 图片上传成功后触发
const handleAvatarSuccess = (response) => {
  if (response.code) {
    employee.value.image = response.data;
    ElMessage.success('上传成功')
  } else {
    ElMessage.error(response.msg)
  }
}
// 文件上传之前触发
const beforeAvatarUpload = (rawFile) => {
  if (rawFile.type !== 'image/jpeg' && rawFile.type !== 'image/png') {
    ElMessage.error('Only JPEG and PNG images are allowed')
    return false
  } else if (rawFile.size / 1024 / 1024 > 10) {
    ElMessage.error('Only files up to 10MB are allowed')
    return false
  }
  return true
}

const addExprItem = () => {
  employee.value.exprList.push({
    company: '',
    job: '',
    begin: '',
    end: '',
    time: [],
  });
};

const deleteExprItem = (index) => {
  employee.value.exprList.splice(index, 1);
};

const employeeForm = ref(null);

const edit = async (id) => {
  if (employeeForm.value)
    employeeForm.value.resetFields();
  const res = await queryByIdApi(id);
  if (res.code) {
    employee.value = res.data;
    // 处理时间范围
    if (employee.value.exprList && employee.value.exprList.length) {
      employee.value.exprList.forEach((expr) => {
        if (expr.begin && expr.end) {
          expr.time = [expr.begin, expr.end];
        } else {
          expr.time = [];
        }
      });
    }
    dialogVisible.value = true;
    dialogTitle.value = "Edit Employee";
  }
};

const save = async () => {
  if (!employeeForm.value) return;
  const valid = await employeeForm.value.validate();
  if (!valid) {
    ElMessage.error('Invalid form data');
    return false;
  }
  let res;
  if (employee.value.id) {
    res = await updateEmpApi(employee.value);
  } else {
    res = await addEmpApi(employee.value);
  }
  if (res.code) {
    ElMessage.success('Employee saved successfully');
    dialogVisible.value = false;
    search();
  } else {
    ElMessage.error(res.msg);
  }
};

const deleteEmp = async (ids) => {
  if (!ids || (Array.isArray(ids) && ids.length === 0)) {
    ElMessage.error('No employees selected for deletion');
    return;
  }
  ElMessageBox.confirm(
    "Are you sure you want to delete the selected employee(s)?",
    "Warning",
    {
      confirmButtonText: "Delete",
      cancelButtonText: "Cancel",
      type: "warning",
    }
  )
    .then(async () => {
      const res = await deleteEmpApi(ids);
      if (res.code) {
        ElMessage.success("Employee(s) deleted successfully");
        search();
      } else {
        ElMessage.error(res.msg);
      }
    })
    .catch(() => {
      // Cancelled
    });
};

watch(employee.value.exprList, (newEmp) => {
  if (!newEmp || !employee.value.exprList.length) return;
  newEmp.forEach((expr) => {
    if (expr.time && expr.time.length === 2) {
      expr.begin = expr.time[0];
      expr.end = expr.time[1];
    } else {
      expr.begin = '';
      expr.end = '';
    }
  });
}, { deep: true });

onMounted(async () => {
  search();
  const deptRes = await queryAllDeptApi();
  if (deptRes.code) {
    depts.value = deptRes.data;
  }
});
</script>

<template>
  <div class="container">
    <h1>Emps Management</h1>
    <!-- Search Form -->
    <div class="container">
      <el-form :inline="true" :model="searchEmp" class="demo-form-inline">
        <el-form-item label="Name">
          <el-input v-model="searchEmp.name" placeholder="Name" />
        </el-form-item>
        <el-form-item label="Gender">
          <el-select v-model="searchEmp.gender" placeholder="Gender" clearable>
            <el-option label="Man" value="1" />
            <el-option label="Woman" value="2" />
          </el-select>
        </el-form-item>
        <el-form-item label="Entry Date">
          <el-date-picker v-model="searchEmp.date" type="daterange" range-separator="To" start-placeholder="Start date"
            end-placeholder="End date" value-format="YYYY-MM-DD" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search">Query</el-button>
          <el-button type="default" @click="clear">Clear</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="container">
      <el-button type="primary" @click="addEmp">Add</el-button>
      <el-button type="danger" @click="deleteEmp(selectedEmps.value)">Delete Bunch</el-button>
    </div>
    <div>
      <!-- Employee Table Placeholder -->
      <el-table :data="empList" style="width: 100%"
        @selection-change="val => selectedEmps.value = val.map(item => item.id)">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="name" label="Name" width="180" />
        <el-table-column label="Gender" width="100">
          <template #default="scope">
            <span>{{ scope.row.gender === 1 ? 'Man' : 'Woman' }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="image" label="Image" width="180">
          <template #default="scope">
            <el-image :src="scope.row.image" style="width: 50px; height: 50px" fit="cover" />
          </template>
        </el-table-column>
        <el-table-column prop="deptName" label="Department" width="180" />
        <el-table-column prop="job" label="Job" width="180">
          <template #default="scope">
            <span v-if="scope.row.job == 1">HeadTeacher</span>
            <span v-else-if="scope.row.job == 2">Lecturer</span>
            <span v-else-if="scope.row.job == 3">EmpHeader</span>
            <span v-else-if="scope.row.job == 4">SearchHeader</span>
            <span v-else-if="scope.row.job == 5">Counselor</span>
            <span v-else>Other</span>
          </template>
        </el-table-column>
        <el-table-column prop="entryDate" label="Entry Date" width="180" />
        <el-table-column prop="updateTime" label="Update Time" width="180" />
        <el-table-column label="Actions" width="180">
          <template #default="scope">
            <el-button type="primary" size="small" @click="edit(scope.row.id)"><el-icon>
                <Edit />
              </el-icon>Edit</el-button>
            <el-button type="danger" size="small" @click="deleteEmp(scope.row.id)"><el-icon>
                <Delete />
              </el-icon>Delete</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="container" style="margin-top: 20px;">
      <div class="demonstration">All combined</div>
      <el-pagination v-model:current-page="page" v-model:page-size="pageSize" :page-sizes="[5, 10, 15, 20]"
        :background="background" layout="total, sizes, prev, pager, next, jumper" :total="total"
        @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <el-dialog v-model="dialogVisible" :title="dialogTitle">
      <el-form :model="employee" :rules="rules" ref="employeeForm" label-width="100px">
        <!-- 基本信息 -->
        <!-- 第一行 -->
        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="Username" prop="username">
              <el-input v-model="employee.username" placeholder="Length 2 to 20"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="Name" prop="name">
              <el-input v-model="employee.name" placeholder="Length 2 to 10"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第二行 -->
        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="Gender" prop="gender">
              <el-select v-model="employee.gender" style="width: 100%;">
                <el-option label="Man" value="1"></el-option>
                <el-option label="Woman" value="2"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="Phone Number" prop="phone">
              <el-input v-model="employee.phone"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第三行 -->
        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="Job" prop="job">
              <el-select v-model="employee.job" style="width: 100%;">
                <el-option v-for="job in jobs" :label="job.label" :value="job.value"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="Salary">
              <el-input v-model="employee.salary"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第四行 -->
        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="Department" prop="deptId">
              <el-select v-model="employee.deptId" style="width: 100%;">
                <el-option v-for="dept in depts" :label="dept.name" :value="dept.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="Entry Date">
              <el-date-picker v-model="employee.entryDate" type="date" style="width: 100%;" format="YYYY-MM-DD"
                value-format="YYYY-MM-DD"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第五行 -->
        <el-row :gutter="10">
          <el-col :span="24">
            <el-form-item label="Image" prop="image">
              <el-upload class="avatar-uploader" action="/api/upload" :show-file-list="false"
                :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload" :headers="{ 'token': tolen }">
                <img v-if="employee.image" :src="employee.image" class="avatar" />
                <el-icon v-else class="avatar-uploader-icon">
                  <Plus />
                </el-icon>
              </el-upload>
            </el-form-item>
          </el-col>
        </el-row>


        <!-- 工作经历 -->
        <!-- 第六行 -->
        <el-row :gutter="10">
          <el-col :span="24">
            <el-form-item label="Work Experience">
              <el-button type="success" size="small" @click="addExprItem">Add Work Experience</el-button>
            </el-form-item>
          </el-col>
        </el-row>

        <!-- 第七行 ...  工作经历 -->
        <el-row :gutter="3" v-for="(exprItem, index) in employee.exprList" :key="index" style="margin-bottom: 10px;">
          <el-col :span="10">
            <el-form-item size="small" label="Time" label-width="80px">
              <el-date-picker type="daterange" range-separator="to" start-placeholder="Start" end-placeholder="End"
                format="YYYY-MM-DD" value-format="YYYY-MM-DD" v-model="exprItem.time"></el-date-picker>
            </el-form-item>
          </el-col>

          <el-col :span="6">
            <el-form-item size="small" label="Company" label-width="60px" prop="company">
              <el-input v-model="exprItem.company"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="6">
            <el-form-item size="small" label="Position" label-width="60px" prop="job">
              <el-input v-model="exprItem.job"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="2">
            <el-form-item size="small" label-width="0px">
              <el-button type="danger" @click="deleteExprItem(index)">Delete</el-button>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>

      <!-- 底部按钮 -->
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="save">Save</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<style scoped>
.container {
  margin: 10px 0px;
}
</style>