import { fetchUsers, fetchUser, addUser, updateUser, removeUser } from "./usersThonks";

export const extraReducers = (builder) => {
    builder
    .addCase(fetchUsers.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(fetchUsers.fulfilled, (state, action) => {
        state.loading = false;
        state.users = action.payload;
        state.allUsers = action.payload;
    })
    .addCase(fetchUsers.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(fetchUser.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(fetchUser.fulfilled, (state, action) => {
        state.loading = false;
        state.user = action.payload;
    })
    .addCase(fetchUser.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(addUser.pending, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(addUser.fulfilled, (state, action) => {
        state.loading = false;
        state.users.push(action.payload);
        state.allUsers.push(action.payload);
    })
    .addCase(addUser.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(updateUser.pending, (state, action) => {
        state.loading = false;
        state.error = null;
    })
    .addCase(updateUser.fulfilled, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
    })
    .addCase(updateUser.rejected, (state) => {
        state.loading = true;
        state.error = null;
    })
    .addCase(removeUser.pending, (state, action) => {
        state.loading = false;
        state.error = null;
    })
    .addCase(removeUser.fulfilled, (state, action) => {
        state.loading = false;
        
        state.users = state.allPosts.filter(p => p.id != id);
        state.allUsers = state.allPosts.filter(p => p.id != id);
    })
    .addCase(removeUser.rejected, (state, action) => {
        state.loading = true;
        state.error = action.error.message;
    })
}