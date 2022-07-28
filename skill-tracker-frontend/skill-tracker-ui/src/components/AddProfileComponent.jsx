import React, { useState } from 'react'
import {Link} from 'react-router-dom'

// import {useHistory} from 'react-router-dom';
import ProfileService from '../services/ProfileService'

const AddProfileComponent = () => {
  
  
    
  const [name,setName] = useState(null)
  const [email,setEmail] = useState(null)
  const [mobile,setMobile] = useState(null)
  const [role,setRole] = useState(null)
  const [dob,setDob] = useState(null)


  const [spoken,setSpoken] = useState(0)
  const [communication,setCommunication] = useState(0)
  const [aptitude,setAptitude] = useState(0)

  const [htmlcssjavascript,setHtmlcssjavascript] = useState(0)
  const [angular,setAngular] = useState(0)
  const [react,setReact] = useState(0)
  const [spring,setSpring] = useState(0)
  const [restful,setRestful] = useState(0)
  const [hibernate,setHibernate] = useState(0)
  const [git,setGit] = useState(0)
  const [docker,setDocker] = useState(0)
  const [jenkins,setJenkins] = useState(0)
  const [aws,setAws] = useState(0)
//   const history = useHistory(); 

  const saveProfile = (e)=>{
        e.preventDefault();

        const profile =  {name,email,mobile,role,dob,htmlcssjavascript,angular,react,spring,restful,hibernate,git,docker,jenkins,aws,spoken,communication,aptitude}
        
        ProfileService.createProfile(profile).then((response)=>{
            console.log(response.data)
            // history.push('/skill-tracker/api/v1/admin/profiles')
        }).catch(error => {
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
           <br/>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <h2 className='text-center'>Add Profile</h2>
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Name: </label>
                                <input type="text" placeholder = "Enter Name" name="name" className="form-control" value={name} onChange = {(e)=>setName(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Email: </label>
                                <input type="email" placeholder = "Enter Email" name="email" className="form-control" value={email} onChange = {(e)=>setEmail(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Mobile: </label>
                                <input type="text" placeholder = "Enter Number" name="mobile" className="form-control" value={mobile} onChange = {(e)=>setMobile(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Role: </label>
                                <input type="text" placeholder = "Enter Role" name="role" className="form-control" value={role} onChange = {(e)=>setRole(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>DOB: </label>
                                <input type="text" placeholder = "Enter DOB" name="dob" className="form-control" value={dob} onChange = {(e)=>setDob(e.target.value)}></input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'>HTML-CSS-JavaScript: </label>
                                <input type="number"  name="htmlcssjavascript" min="0" max="20" className="form-control" value={htmlcssjavascript} onChange = {(e)=>setHtmlcssjavascript(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Angular: </label>
                                <input type="number"  name="angular" min="0" max="20" className="form-control" value={angular} onChange = {(e)=>setAngular(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>React: </label>
                                <input type="number"  name="react" min="0" max="20" className="form-control" value={react} onChange = {(e)=>setReact(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Spring: </label>
                                <input type="number"  name="spring" min="0" max="20" className="form-control" value={spring} onChange = {(e)=>setSpring(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Restful: </label>
                                <input type="number"  name="restful" min="0" max="20" className="form-control" value={restful} onChange = {(e)=>setRestful(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Hibernate: </label>
                                <input type="number"  name="hibernate" min="0" max="20" className="form-control" value={hibernate} onChange = {(e)=>setHibernate(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Git: </label>
                                <input type="number"  name="git" min="0" max="20" className="form-control" value={git} onChange = {(e)=>setGit(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Docker: </label>
                                <input type="number"  name="docker" min="0" max="20" className="form-control" value={docker} onChange = {(e)=>setDocker(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Jenkins: </label>
                                <input type="number"  name="jenkins" min="0" max="20" className="form-control" value={jenkins} onChange = {(e)=>setJenkins(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>AWS: </label>
                                <input type="number"  name="aws" min="0" max="20" className="form-control" value={aws} onChange = {(e)=>setAws(e.target.value)}></input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'>Spoken: </label>
                                <input type="number"  name="spoken" min="0" max="20" className="form-control" value={spoken} onChange = {(e)=>setSpoken(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Communication: </label>
                                <input type="number"  name="communication" min="0" max="20" className="form-control" value={communication} onChange = {(e)=>setCommunication(e.target.value)}></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Aptitude: </label>
                                <input type="number"  name="aptitude" min="0" max="20" className="form-control" value={aptitude} onChange = {(e)=>setAptitude(e.target.value)}></input>
                            </div>

                            
                            
                            <div className='form-group mb-2'>
                                <button className='btn btn-success' onClick={(e)=>saveProfile(e)}>
                                    Submit
                                </button>
                            </div>

                            <div className='form-group mb-2'>
                            <Link to="/skill-tracker/api/v1/admin/profiles" className="btn btn-danger mb-2">Cancel</Link> 
                            </div>


                            

                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
  )
}

export default AddProfileComponent