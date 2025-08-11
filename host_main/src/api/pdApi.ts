import { api } from "./axios";

export const fetchServicesApi = async () => {
    const response = await api.get('/services');
    console.log(response);
    return response.data.services;
}
export const fetchServiceApi = async (id : string) => {
    const response = await api.get(`pd/services/${id}`);
    console.log(response);
    return response.data.service;
}

export const addServiceApi = async (data: any) => {
    const response = await api.post('pd/services', data);
    console.log(api);
    return response.data.service;
}

export const updateServiceApi = async () => {

}

export const removeServiceApi = async (id : string) => {
    const response = await api.delete(`pd/services/${id}`);
    return response.data;
}