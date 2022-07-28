import React, { useState } from 'react'
import {Link} from 'react-router-dom'

// import {useHistory} from 'react-router-dom';
import ProfileService from '../services/ProfileService'



const SearchProfileComponent = () => {

  const [profiles,setProfiles] = useState([]);
  const [profile,setProfile] = useState([]);
  const [Name,setName] = useState(null);
  const [Id,setId] = useState(null);
  const [Skill,setSkill] = useState(null);


  const getProfileById = (e)=>{
      e.preventDefault();

      ProfileService.getProfileById(Id).then((response)=>{
              setProfile(response.data)
              console.log(profile);
              // setProfiles([]);
              profiles.push(response.data);
              // console.log(profile);
          }).catch(error =>{
              console.log(error);
          })
  }

  const getProfileByName = (e)=>{
    e.preventDefault();

    ProfileService.getProfileByName(Name).then((response)=>{
            setProfiles(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
}

const getProfileBySkill = (e)=>{
  e.preventDefault();

  ProfileService.getProfileBySkill(Skill).then((response)=>{
          setProfiles(response.data)
          console.log(response.data);
      }).catch(error =>{
          console.log(error);
      })
}

  return (
    <div>
    <br/>
    <br/>
    <div className='container'>
    <br/><br/>
      <div className='row'>
          <div className='form-group mb-2'>
            
                <Link to="/skill-tracker/api/v1/admin/profiles" className="btn btn-primary mb-2">Home</Link> 
             </div>
           </div>
        <div className='row'>
            <div className='card col-md-3 offset-md-1 offset-md-1'>
                <h5 className='text-center'>Search Profiles by Name</h5>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Name: </label>
                            <input type="text" placeholder = "Enter Name" name="Name" className="form-control" value={Name} onChange = {(e)=>setName(e.target.value)}></input>
                        </div>
                        <div className='form-group mb-2'>
                            <button className='btn btn-success' onClick={(e)=>getProfileByName(e)}>
                                Submit
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div className='card col-md-3 offset-md-1 offset-md-1'>
                <h5 className='text-center'>Search Profile by Skills</h5>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Skill: </label>
                            <input type="text" placeholder = "Enter Skill" name="Skill" className="form-control" value={Skill} onChange = {(e)=>setSkill(e.target.value)}></input>
                        </div>
                        <div className='form-group mb-2'>
                            <button className='btn btn-success' onClick={(e)=>getProfileBySkill(e)}>
                                Submit
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div className='card col-md-3 offset-md-1 offset-md-1'>
                <h5 className='text-center'>Search Profile by SKills</h5>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>ID: </label>
                            <input type="text" placeholder = "Enter ID" name="id" className="form-control" value={Id} onChange = {(e)=>setId(e.target.value)}></input>
                        </div>
                        <div className='form-group mb-2'>
                            <button className='btn btn-success' onClick={(e)=>getProfileById(e)}>
                                Submit
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
          <div className="container">
          <h2 className="text-center">
              Search Result
          </h2> 
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
                                  <Link style={{marginLeft:"10px"}} to={`/skill-tracker/api/v1/admin/ID/${profile.id}`} className="btn btn-primary mb-2">View</Link>
                              </td>
                          </tr>
                      )
                  }
              </tbody>
          </table>
      </div>
    </div>

</div>
  )
}

export default SearchProfileComponent