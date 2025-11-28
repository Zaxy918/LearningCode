<script setup>
import { ref, onMounted } from "vue";
import { queryAllApi, addDeptApi, queryByIdApi, updateDeptApi, deleteDeptApi } from '@/api/dept';
import { ElMessage, ElMessageBox } from "element-plus";

/* Methods */
const search = async () => {
  const res = await queryAllApi();
  if (res.code) deptList.value = res.data;
};
const save = async () => {
  // Validate form
  if (!deptFormRef.value) return;
  deptFormRef.value.validate((async (valid) => {
    if (valid) {
      let result;
      if (!dept.value.id) {
        result = await addDeptApi(dept.value);
      } else {
        result = await updateDeptApi(dept.value);
      }
      if (result.code) {
        ElMessage.success("Save successful");
        dialogFormVisible.value = false;
        search();
      } else {
        ElMessage.error(result.msg);
      }
    } else {
      ElMessage.error("Invalid form data");
      return false;
    }
  }));
};
const addDept = () => {
  dialogFormVisible.value = true;
  dialogTitle.value = "Add Dept";
  dept.value = { name: "" };
  // if (deptFormRef.value)
  deptFormRef.value.resetFields();
}
const editDept = async (id) => {
  if (deptFormRef.value)
    deptFormRef.value.resetFields();
  const res = await queryByIdApi(id);
  if (res.code) {
    dept.value = res.data;
    dialogFormVisible.value = true;
    dialogTitle.value = "Edit Dept";
  }
}
const deleteById = async (id) => {
  ElMessageBox.confirm(
    "Are you sure you want to delete this dept?",
    "Warning",
    {
      confirmButtonText: "Delete",
      cancelButtonText: "Cancel",
      type: "warning",
    }
  )
    .then(async () => {
      const res = await deleteDeptApi(id);
      if (res.code) {
        ElMessage.success("Delete successful");
        search();
      } else {
        ElMessage.error(res.msg);
      }
    })
    .catch(() => {
      ElMessage.info("Delete canceled");
    });
};
const rules = ref({
  name: [
    { required: true, message: "Please input dept name", trigger: "blur" },
    { min: 2, max: 10, message: "Length should be 2 to 10", trigger: "blur" }
  ],
});

/* Data */
const dept = ref({
  name: "",
});
const deptList = ref([]);
const dialogFormVisible = ref(false);
const dialogTitle = ref("");
const deptFormRef = ref();

/* Lifecycle Hooks */
onMounted(() => {
  search();
});
</script>

<template>
  <h1>Depts Management</h1>
  <div class="container">
    <el-button type="primary" @click="addDept">Add Dept</el-button>
  </div>
  <!-- Table of Depts -->
  <div class="container">
    <el-table :data="deptList" border style="width: 100%">
      <el-table-column type="index" label="Index" width="100" align="center" />
      <el-table-column prop="name" label="Dept Name" align="center" />
      <el-table-column prop="updateTime" label="Update Time" align="center" />
      <el-table-column label="Actions" width="220">
        <template #default="scope">
          <el-button type="primary" size="small" @click="editDept(scope.row.id)"><el-icon>
              <Edit />
            </el-icon>Edit</el-button>
          <el-button type="danger" size="small" @click="deleteById(scope.row.id)"><el-icon>
              <Delete />
            </el-icon>Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
  <!-- Add/Edit Dept Dialog -->
  <el-dialog v-model="dialogFormVisible" :title="dialogTitle" width="500">
    <el-form :model="dept" :rules="rules" ref="deptFormRef">
      <el-form-item label="Name" label-width="80px" prop="name">
        <el-input v-model="dept.name" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="save">Confirm</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>
.container {
  margin: 10px 0px;
}
</style>
