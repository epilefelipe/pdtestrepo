import { createAsyncThunk } from '@reduxjs/toolkit';
import { addServiceApi, fetchServicesApi, fetchServiceApi, removeServiceApi, updateServiceApi } from '../../api/pdApi';


export const addService = createAsyncThunk('services/add', async (data) => {
    return await addServiceApi(data);
})

export const fetchServices = createAsyncThunk('services/fetch', async () => {
    return await fetchServicesApi();
})
export const fetchService = createAsyncThunk('service/fetch', async (id : string) => {
    return await fetchServiceApi(id);
})

export const updateService = createAsyncThunk('services/update', async () => {
    return await updateServiceApi();
})

export const removeService = createAsyncThunk('services/remove', async (id : string) => {
    return await removeServiceApi(id);
})