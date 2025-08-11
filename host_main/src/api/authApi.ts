import { api } from "./axios";

export const signInApi = async () => {
    const response = await api.post('auth/signin');
    console.log(response);
    return response.data;
}
export const signUpApi = async () => {
    const response = await api.post(`auth/signup`);
    console.log(response);
    return response.data;
}

export const signOutApi = async () => {
    const response = await api.post('auth/signout');
    console.log(api);
    return response.data;
}