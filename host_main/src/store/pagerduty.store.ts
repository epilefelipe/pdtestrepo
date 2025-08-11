import { configureStore } from  '@reduxjs/toolkit';
import servicesReducer from '../features/services/servicesSlice';
import authReducer from '../features/auth/authSlice';

const store = configureStore({
    reducer: {
        services: servicesReducer,
        auth: authReducer
    }
})

export default store;
