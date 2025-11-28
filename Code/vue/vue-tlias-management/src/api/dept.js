import request from "@/utils/request";

export const queryAllApi = () => request.get('/depts');

export const addDeptApi = (dept) => request.post('/depts', dept);

export const queryByIdApi = (id) => request.get(`/depts/${id}`);

export const updateDeptApi = (dept) => request.put('/depts', dept);

export const deleteDeptApi = (id) => request.delete(`/depts?id=${id}`);