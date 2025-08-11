import { createAsyncThunk } from '@reduxjs/toolkit';
import { addUserApi, fetchUsersApi, fetchUserApi, removeUserApi, updateUserApi } from '../../api/userApi';


export const addUser = createAsyncThunk('users/add', async (data) => {
    return await addUserApi(data);
})

export const fetchUsers = createAsyncThunk('users/fetch', async () => {
    return await fetchUsersApi();
})
export const fetchUser = createAsyncThunk('user/fetch', async (id : string) => {
    return await fetchUserApi(id);
})

export const updateUser = createAsyncThunk('users/update', async () => {
    return await updateUserApi();
})

export const removeUser = createAsyncThunk('users/remove', async (id : string) => {
    return await removeUserApi(id);
})