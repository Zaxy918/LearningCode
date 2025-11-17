<script setup>
const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
</script>

<template>
  <div id="emp-list-view">
    <div class="search-inputs">
      Name <el-input v-model="name" style="width: 240px" placeholder="Please Input" :suffix-icon="Search" />
      Gender <el-input v-model="gender" style="width: 240px" placeholder="Please Input" :suffix-icon="Search" />
      Position <el-input v-model="position" style="width: 240px" placeholder="Please Input" :suffix-icon="Search" />
      <el-button class="equal-btn" type="primary">Search</el-button>
      <el-button class="equal-btn" type="primary">Clear</el-button>
    </div>
    <div class="table-container">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="date" label="Date" width="180" align="center" />
        <el-table-column prop="name" label="Name" width="180" align="center" />
        <el-table-column prop="address" label="Address" align="center" />
      </el-table>
    </div>
  </div>
</template>

<style scoped>
#emp-list-view {
  width: 100%;
  height: 100%;
  align-items: center;
  display: flex;
  justify-content: center;
  flex-direction: column;
}

.search-inputs {
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 20px;
  padding: 20px;
  width: 80%;
  justify-content: center;
}

.table-container {
  width: 80%;
  justify-content: center;
}

.equal-btn {
  width: 120px;
  /* fixed width so both buttons are same length */
  display: inline-flex;
  justify-content: center;
  align-items: center;
}
</style>
