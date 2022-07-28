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

    getProfileById(id){
        return axios.get('http://localhost:8080/skill-tracker/api/v1/admin/ID/'+id)
    }

    getProfileBySkill(skill){
        return axios.get('http://localhost:8080/skill-tracker/api/v1/admin/skill/'+skill)
    }

    getProfileByName(name){
        return axios.get('http://localhost:8080/skill-tracker/api/v1/admin/names/'+name)
    }


}

export default new ProfileService();