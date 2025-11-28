import axios from 'axios';
import router from '@/router';
import { ElMessage } from 'element-plus';

const request = axios.create({
  baseURL: '/api', // Replace with your API base URL
  timeout: 500000, // Request timeout
});

request.interceptors.request.use(
  config => {
    const token = JSON.parse(localStorage.getItem('loginUser'))?.token;
    if (token) {
      config.headers.token = token;
    }
    return config;
  }
);

request.interceptors.response.use(
  response => {
    return response.data;
  },
  error => {
    if (error.response) {
      if (error.response.status === 401) {
        // Handle unauthorized access, e.g., redirect to login
        ElMessage.error('Session expired. Please log in again.');
        router.push('/login');
      }
    }
    return Promise.reject(error);
  }
)
export default request;