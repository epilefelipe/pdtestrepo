import { createSlice } from '@reduxjs/toolkit';
import { reducers } from './servicesReducers';
import { extraReducers } from './servicesExtraReducers';

const initialState = {
    allServices: [],
    services: [],
    service: null,
    filter: '',
    loading: false,
    error: null
}

const serviceSlice = createSlice({
    name: 'services',
    initialState,
    reducers,
    extraReducers
})

export const { setService, addService, updateService, removeService, filterService } = serviceSlice.actions;
export default serviceSlice.reducer;