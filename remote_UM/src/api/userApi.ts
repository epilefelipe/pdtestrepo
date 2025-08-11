import { api } from "./axios";

export const fetchUsersApi = async () => {
    const response = await api.get('/users');
    console.log(response);
    return response.data.users;
}
export const fetchUserApi = async (id : string) => {
    const response = await api.get(`/users/${id}`);
    console.log(response);
    return response.data.service;
}

export const addUserApi = async (data: any) => {
    const response = await api.post('/users', data);
    console.log(api);
    return response.data.service;
}

export const updateUserApi = async () => {

}

export const removeUserApi = async (id : string) => {
    const response = await api.delete(`/users/${id}`);
    return response.data;
}