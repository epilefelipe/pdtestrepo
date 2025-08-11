import { signinService, signupService, signoutService } from "./authThonks";

export const extraReducers = (builder) => {
    builder
    .addCase(signinService.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(signinService.fulfilled, (state, action) => {
        state.loading = false;
        state.session = action.payload;
    })
    .addCase(signinService.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(signupService.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(signupService.fulfilled, (state, action) => {
        state.loading = false;
    })
    .addCase(signupService.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(signoutService.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(signoutService.fulfilled, (state, action) => {
        state.loading = false;
    })
    .addCase(signoutService.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
}