
export const reducers = {
    setService(state, action){
        state.allservices = action.payload;
        state.services = action.payload;
    },
    addService(state, action){
        state.services.push(action.payload);
    },
    updateService(state, action){
        const updateService = action.payload;
        const service = state.services.find(p => p.id == updateService.id);
        
        if(service){
            Object.assign(service, updateService);
        }
    },
    removeService(state, action){
        const id = action.payload;
        state.services = state.services.filter(p => p.id !== id);
    },
    filterService(state, action){
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