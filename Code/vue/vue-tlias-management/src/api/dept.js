import request from "@/utils/request";

export const queryAllApi = () => request.get('/depts');

export const addDeptApi = (dept) => request.post('/depts', dept);