import React from 'react'
import { useState, useEffect } from 'react'
import {Link} from 'react-router-dom'
import ProfileService from '../services/ProfileService';

const ListAllProfiles = () => {

  const [profiles,setProfiles] = useState([]);
  
  useEffect(() => {
    ProfileService.getProfiles().then((response)=>{
        setProfiles(response.data)
        console.log(response.data);
    }).catch(error =>{
        console.log(error);
    })
  }, [])

  const getAllProfiles = ()=>{
    ProfileService.getProfiles().then((response)=>{
        setProfiles(response.data)
        console.log(response.data);
    }).catch(error =>{
        console.log(error);
    })
  }
  
  const deleteProfileById = (id)=>{
    ProfileService.deleteProfileById(id).then((response)=>{
        getAllProfiles();
    }).catch(error=>{
        console.log(error);
    })
    console.log(id);

  }

  return (
    <div className="container">
        <h2 className="text-center">
            Enginners List
        </h2>
       <Link to="/skill-tracker/api/v1/engineer/add-profile" className="btn btn-primary mb-2">Add Engineer
       </Link>
       
       <Link style={{marginLeft:"10px"}} to="/skill-tracker/api/v1/engineer/search-profile" className="btn btn-primary mb-2">Search Engineer
       </Link>  
        <table className="table table-bordered table-striped">
            <thead>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Actions</th>
            </thead>   
            <tbody>
                {
                    profiles.map(
                        profile => 
                        <tr key={profile.id}>
                            <td>{profile.id}</td>
                            <td>{profile.name}</td>
                            <td>{profile.email}</td>
                            <td>{profile.mobile}</td>
                            <td>
                                <button className='btn btn-danger' onClick={()=>{deleteProfileById(profile.id)}}>Delete</button>
                                <Link style={{marginLeft:"10px"}} to={`/skill-tracker/api/v1/admin/ID/${profile.id}`} className="btn btn-primary mb-2">View</Link>
                            </td>
                            
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListAllProfiles