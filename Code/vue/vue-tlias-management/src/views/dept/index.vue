<script setup>
import { ref, onMounted } from "vue";
import { queryAllApi, addDeptApi } from '@/api/dept';
import { ElMessage } from "element-plus";

const search = async () => {
  const res = await queryAllApi();
  if (res.code) deptList.value = res.data;
};
const save = async () => {
  const result = await addDeptApi(dept.value)
  if (result.code) {
    ElMessage.success("Save successful");
    dialogFormVisible.value = false;
    search();
  } else {
    ElMessage.error(result.msg);
  }
};
const addDept = () => { dialogFormVisible.value = true; dialogTitle.value = "Add Dept"; dept.value = { name: "" }; }
const editDept = (row) => { dialogFormVisible.value = true; dialogTitle.value = "Edit Dept"; dept.value = { ...row }; }
const rules = ref({
  name: [
    { required: true, message: "Please input dept name", trigger: "blur" },
    { min: 2, max: 10, message: "Length should be 2 to 10", trigger: "blur" }
  ],
});

const dept = ref({
  name: "",
});
const deptList = ref([]);
const dialogFormVisible = ref(false);
const dialogTitle = ref("");

onMounted(() => {
  search();
});
</script>

<template>
  <h1>Depts Management</h1>
  <div class="container">
    <el-button type="primary" @click="addDept">Add Dept</el-button>
  </div>
  <div class="container">
    <el-table :data="deptList" border style="width: 100%">
      <el-table-column type="index" label="Index" width="100" align="center" />
      <el-table-column prop="name" label="Dept Name" align="center" />
      <el-table-column prop="updateTime" label="Update Time" align="center" />
      <el-table-column label="Actions" width="220">
        <template #default="scope">
          <el-button type="primary" size="small" @click="editDept(scope.row)"><el-icon>
              <Edit />
            </el-icon>Edit</el-button>
          <el-button type="danger" size="small"><el-icon>
              <Delete />
            </el-icon>Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <el-dialog v-model="dialogFormVisible" :title="dialogTitle" width="500">
    <el-form :model="dept" :rules="rules">
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
