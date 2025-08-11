import { fetchServices, fetchService, addService, updateService, removeService } from "./servicesThonks";

export const extraReducers = (builder) => {
    builder
    .addCase(fetchServices.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(fetchServices.fulfilled, (state, action) => {
        state.loading = false;
        state.services = action.payload;
        state.allServices = action.payload;
    })
    .addCase(fetchServices.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(fetchService.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(fetchService.fulfilled, (state, action) => {
        state.loading = false;
        state.service = action.payload;
    })
    .addCase(fetchService.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(addService.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(addService.fulfilled, (state, action) => {
        state.loading = false;
        state.services.push(action.payload);
        state.allservices.push(action.payload);
    })
    .addCase(addService.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(updateService.fulfilled, (state, action) => {
        state.loading = false;
        state.services.push(action.payload);
        state.allservices.push(action.payload);
    })
    .addCase(updateService.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(updateService.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(removeService.fulfilled, (state, action) => {
        state.loading = false;
        const id = action.payload.id;
        console.log(id);

        state.posts = state.allPosts.filter(p => p.id != id);
        state.allPosts = state.allPosts.filter(p => p.id != id);
    })
    .addCase(removeService.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
}