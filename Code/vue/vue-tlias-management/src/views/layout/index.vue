<script setup>
import { ref, onMounted } from 'vue';
import { ElMessageBox } from 'element-plus';
import router from '@/router';

const loginUser = ref('');

const logout = () => {
  ElMessageBox.confirm(
    'Are you sure you want to logout?',
    'Logout Confirmation',
    {
      confirmButtonText: 'Logout',
      cancelButtonText: 'Cancel',
      type: 'warning',
    }
  ).then(() => {
    // Clear user data from localStorage
    localStorage.removeItem('loginUser');
    // Redirect to login page
    router.push('/login');
  }).catch(() => {
    // User cancelled logout
  });
};

onMounted(() => {
  const user = JSON.parse(localStorage.getItem('loginUser'));
  if (user && user.username) {
    loginUser.value = user.username;
  }
});
</script>

<template>
  <div class="common-layout">
    <el-container>
      <!-- Header 区域 -->
      <el-header class="header">
        <span class="title">Tlias Management</span>
        <span class="right_tool">
          <a href="">
            <el-icon>
              <EditPen />
            </el-icon> Change Password &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;
          </a>
          <a href="javascript:void(0)" @click="logout">
            <el-icon>
              <SwitchButton />
            </el-icon> Logout [{{ loginUser }}]
          </a>
        </span>
      </el-header>

      <el-container>
        <!-- 左侧菜单 -->
        <el-aside width="200px" class="aside">
          <el-menu router>
            <!-- Home page -->
            <el-menu-item index="/index" class="gray-menu">
              <template #title>
                <el-icon>
                  <Promotion />
                </el-icon>HOME
              </template>
            </el-menu-item>
            <!-- Class and Students -->
            <el-sub-menu index="/csman" class="gray-menu">
              <template #title>
                <el-icon>
                  <Menu />
                </el-icon>Class and Students
              </template>
              <el-menu-item index="/clazz"><el-icon>
                  <HomeFilled />
                </el-icon>Class Management</el-menu-item>
              <el-menu-item index="/stu"><el-icon>
                  <UserFilled />
                </el-icon>Student Management</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="/deman" class="gray-menu">
              <template #title>
                <el-icon>
                  <Tools />
                </el-icon>Depts and Emps
              </template>
              <el-menu-item index="/depts"><el-icon>
                  <HelpFilled />
                </el-icon>Depts Management</el-menu-item>
              <el-menu-item index="/emps"><el-icon>
                  <Avatar />
                </el-icon>Emps Management</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="/stat" class="gray-menu">
              <template #title>
                <el-icon>
                  <Histogram />
                </el-icon>Statistics
              </template>
              <el-menu-item index="/empReport"><el-icon>
                  <InfoFilled />
                </el-icon>Emps Info</el-menu-item>
              <el-menu-item index="/stuReport"><el-icon>
                  <QuestionFilled />
                </el-icon>Students Info</el-menu-item>
              <el-menu-item index="/log"><el-icon>
                  <List />
                </el-icon>Log Info</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-aside>

        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>

    </el-container>
  </div>
</template>

<style scoped>
.header {
  background-image: linear-gradient(to right, #00547d, #007fa4, #00aaa0, #00d072, #a8eb12);
}

.title {
  color: white;
  font-size: 40px;
  font-family: 楷体;
  line-height: 60px;
  font-weight: bolder;
}

.right_tool {
  float: right;
  line-height: 60px;
}

a {
  color: white;
  text-decoration: none;
}

.aside {
  width: 220px;
  border-right: 1px solid #ccc;
  height: 730px;
}

.gray-menu {
  background-color: #e9e9e9;
}
</style>
