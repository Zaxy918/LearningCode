<script setup>
import { ref } from 'vue'
import { loginApi } from '@/api/login';
import { useRouter } from 'vue-router';
import { ElMessage } from 'element-plus';

let loginForm = ref({ username: '', password: '' })
const router = useRouter();

const login = async () => {
  const res = await loginApi(loginForm.value);
  if (res.code) {
    // Store token in localStorage
    localStorage.setItem('loginUser', JSON.stringify(res.data));
    // Redirect to home page
    router.push('/');
  } else {
    ElMessage.error(res.msg);
  }
}

const clear = () => {
  loginForm.value.username = '';
  loginForm.value.password = '';
};

</script>

<template>
  <div id="container">
    <div class="login-form">
      <el-form label-width="80px">
        <p class="title">Tlias Management</p>
        <el-form-item label="Username" prop="username">
          <el-input v-model="loginForm.username" placeholder="Enter your username"></el-input>
        </el-form-item>

        <el-form-item label="Password" prop="password">
          <el-input type="password" v-model="loginForm.password" placeholder="Enter your password"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button class="button" type="primary" @click="login">Log In</el-button>
          <el-button class="button" type="info" @click="clear">Clear</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style scoped>
#container {
  padding: 10%;
  height: 410px;
  background-image: url('../../assets/bg1.jpg');
  background-repeat: no-repeat;
  background-size: cover;
}

.login-form {
  max-width: 400px;
  padding: 30px;
  margin: 0 auto;
  border: 1px solid #e0e0e0;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  background-color: white;
}

.title {
  font-size: 30px;
  font-family: '楷体';
  text-align: center;
  margin-bottom: 30px;
  font-weight: bold;
}

.button {
  margin-top: 30px;
  width: 120px;
}
</style>