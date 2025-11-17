import axios from 'axios';

const request = axios.create({
  baseURL: '/api', // Replace with your API base URL
  timeout: 500000, // Request timeout
});

request.interceptors.response.use(
  response => {
    return response.data;
  },
  error => {
    return Promise.reject(error);
  }
)
export default request;