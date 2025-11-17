<script setup>
  import { ref, onMounted } from "vue";
  import axios from 'axios';

  const name = ref('');
  const gender = ref('');
  const job = ref('');
  const userList = ref([]);

  const search = async () => {
    console.log('Search clicked');
    const result = await axios.get(`https://web-server.ithema.net/emps/list?name=${name.value}&gender=${gender.value}&job=${job.value}`);
    userList.value = result.data.data;
  }

  onMounted(() => {
    search();
  });
</script>

<template>
  <div id="center">
    Name: <input type="text"  name="name" v-model="name"/>

    Gender:
    <select name="gender" v-model="gender">
      <option value="1">Man</option>
      <option value="2">Woman</option>
    </select>

    Position:
    <select name="job" v-model="job">
      <option value="1">HeadTeacher</option>
      <option value="2">Teacher</option>
      <option value="3">Other</option>
    </select>

    <input class="btn" type="button" value="Search" @click="search"/>
  </div>
  <table>
    <tr>
      <th>Number</th>
      <th>Name</th>
      <th>Image</th>
      <th>Gender</th>
      <th>Position</th>
      <th>EntryDate</th>
      <th>UpdateTime</th>
    </tr>
    <tr v-for="(user, index) in userList" :key="user.id">
      <td>{{ index + 1 }}</td>
      <td>{{ user.name }}</td>
      <td><img :src="user.image"/></td>
      <td>
        <span v-if="user.gender == 1">Man</span>
        <span v-else-if="user.gender == 2">Woman</span>
      </td>
      <td>
        <span v-if="user.job == 1">HeadTeacher</span>
        <span v-else-if="user.job == 2">Teacher</span>
        <span v-else-if="user.job == 3">HeadEmp</span>
        <span v-else-if="user.job == 4">HeadResearch</span>
        <span v-else-if="user.job == 5">Counselor</span>
        <span v-else>Other</span>
      </td>
    </tr>
  </table>
</template>

<style scoped>
  table,th,td {
    border: 1px solid #000;
    border-collapse: collapse;
    line-height: 50px;
    text-align: center;
  }

  #center,table {
    width: 60%;
    margin: auto;
  }

  #center {
    margin-bottom: 20px;
  }

  img {
    width: 50px;
  }

  input,select {
    width: 16%;
    padding: 10px;
    margin-right: 30px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  .btn {
    background-color: #ccc;
  }
</style>