<script setup>

</script>

<template>
  <div id="cneter">
    Name: <input type="text"  name="name" v-model="name"></input>

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

    <input class="btn" type="button" 
  </div>
</template>