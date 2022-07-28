import React, { useEffect, useState } from 'react'
import {useParams} from 'react-router-dom'
import {Link} from 'react-router-dom'
import ProfileService from '../services/ProfileService';
export default function ViewProfileComponent() {

    const {id} = useParams();
    const [profile,setProfile] = useState([]);
  
  useEffect(() => {
    ProfileService.getProfileById(id).then((response)=>{
        setProfile(response.data)
        console.log(response.data);
    }).catch(error =>{
        console.log(error);
    })
  }, [id])

  return (
    <div className="container">
      <br/><br/>
      <div className='row'>
          <div className='form-group mb-2'>
            
                <Link to="/skill-tracker/api/v1/admin/profiles" className="btn btn-primary mb-2">Home</Link> 
             </div>
           </div>
        <h2 className="text-center">
            Enginner Details
        </h2> 
        <table className="table table-bordered table-striped">

            <thead>
              <tr>
                    <th style={{textAlign:"center"}}colSpan={2}>Personal Information</th>
                    
                </tr>
            </thead>   
            <tbody>
                <tr>
                    <th>ID</th>
                    <td>{profile.id}</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>{profile.name}</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>{profile.email}</td>
                </tr>
                <tr>
                    <th>Mobile</th>
                    <td>{profile.mobile}</td>
                </tr>
                <tr>
                    <th style={{textAlign:"center"}}colSpan={2}>Technology</th>
                    
                </tr>
                <tr>
                    <th>HTML-CSS-JavaScript</th>
                    <td>{profile.htmlcssjavascript}</td>
                </tr>
                <tr>
                    <th>Angular</th>
                    <td>{profile.angular}</td>
                </tr>
                <tr>
                    <th>React</th>
                    <td>{profile.react}</td>
                </tr>
                <tr>
                    <th>Spring</th>
                    <td>{profile.spring}</td>
                </tr>
                <tr>
                    <th>Restful</th>
                    <td>{profile.restful}</td>
                </tr>
                <tr>
                    <th>Jenkins</th>
                    <td>{profile.jenkins}</td>
                </tr>
                <tr>
                    <th>AWS</th>
                    <td>{profile.aws}</td>
                </tr>
                <tr>
                    <th>Docker</th>
                    <td>{profile.docker}</td>
                </tr>
                <tr>
                    <th>Git</th>
                    <td>{profile.git}</td>
                </tr>
                <tr>
                    <th>Hibernate</th>
                    <td>{profile.hibernate}</td>
                </tr>
                <tr>
                    <th style={{textAlign:"center"}}colSpan={2}>Soft Skills</th>
                    
                </tr>
                <tr>
                    <th>Spoken</th>
                    <td>{profile.spoken}</td>
                </tr>
                <tr>
                    <th>Communication</th>
                    <td>{profile.communication}</td>
                </tr>
                <tr>
                    <th>Aptitude</th>
                    <td>{profile.aptitude}</td>
                </tr>
                {/* {
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
                } */}
            </tbody>
        </table>
    </div>
  )
}
