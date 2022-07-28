import axios from 'axios';

const PROFILE_API_BASE_URL = 'http://localhost:8080/skill-tracker/api/v1/admin/profiles';

class ProfileService{
    getProfiles(){
        return axios.get(PROFILE_API_BASE_URL);
    }

    createProfile(profile){
        return axios.post('http://localhost:8080/skill-tracker/api/v1/engineer/add-profile',profile)
    }

    deleteProfileById(id){
        return axios.delete('http://localhost:8080/skill-tracker/api/v1/admin/delete-profile/'+id)
    }
}

export default new ProfileService();