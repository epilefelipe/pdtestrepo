import { createAsyncThunk } from '@reduxjs/toolkit';
import { signInApi, signUpApi, signOutApi } from '../../api/authApi';


export const signinService = createAsyncThunk('services/add', async (data) => {
    return await signInApi(data);
})

export const signupService = createAsyncThunk('services/add', async (data) => {
    return await signUpApi(data);
})

export const signoutService = createAsyncThunk('services/add', async (data) => {
    return await signOutApi(data);
})