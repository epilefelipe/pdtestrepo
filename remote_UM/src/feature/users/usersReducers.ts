
export const reducers = {
    setUser(state, action){
        state.allservices = action.payload;
        state.services = action.payload;
    },
    addUser(state, action){
        state.services.push(action.payload);
    },
    updateUser(state, action){
        const updateService = action.payload;
        const service = state.services.find(p => p.id == updateService.id);
        
        if(service){
            Object.assign(service, updateService);
        }
    },
    removeUser(state, action){
        const id = action.payload;
        state.services = state.services.filter(p => p.id !== id);
    },
    filterUser(state, action){
        const searchText = action.payload.toLowerCase()
        console.log('llega?');
        if(!searchText){
            state.services = state.allservices;
            state.filter = "";
            
        }else{
            state.filter = searchText;
            state.services = state.allservices.filter(s => s.name.toLowerCase().includes(searchText));
        }
    }
}