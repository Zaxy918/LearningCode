import request from "@/utils/request";

export const queryPageApi = (name, gender, begin, end, page, pageSize) =>
  request.get(`/emps?name=${name}&gender=${gender}&begin=${begin}&end=${end}&page=${page}&pageSize=${pageSize}`);

export const addEmpApi = (emp) => request.post('/emps', emp);

export const queryByIdApi = (id) => request.get(`/emps/${id}`);

export const updateEmpApi = (emp) => request.put('/emps', emp);

export const deleteEmpApi = (ids) => request.delete(`/emps?ids=${ids}`);