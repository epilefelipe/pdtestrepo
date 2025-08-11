import { createSlice } from '@reduxjs/toolkit';
import { reducers } from './usersReducers';
import { extraReducers } from './usersExtraReducers';

const initialState = {
    allUsers: [],
    users: [],
    user: null,
    filter: '',
    loading: false,
    error: null
}

const usersSlice = createSlice({
    name: 'users',
    initialState,
    reducers,
    extraReducers
})

export const { setUser, addUser, updateUser, removeUser, filterUser } = usersSlice.actions;
export default usersSlice.reducer;