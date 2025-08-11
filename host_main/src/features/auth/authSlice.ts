import { createSlice } from '@reduxjs/toolkit';
import { reducers } from './authReducers';
import { extraReducers } from './authExtraReducers';

const initialState = {
    session: null,
    loading: false,
    error: null
}

const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers,
    extraReducers
})

export const { setSession, signin, signup, signout } = authSlice.actions;
export default authSlice.reducer;