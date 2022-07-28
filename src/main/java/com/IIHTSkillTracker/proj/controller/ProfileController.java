package com.IIHTSkillTracker.proj.controller;

//import java.util.Date;
import java.util.List;
//import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IIHTSkillTracker.proj.exception.profileException;
import com.IIHTSkillTracker.proj.model.ProfileDTO;
//import com.IIHTSkillTracker.proj.repository.ProfileRepository;
import com.IIHTSkillTracker.proj.service.ProfileService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("/skill-tracker/api/v1/admin/profiles")
	public ResponseEntity<?> getAllProfiles(){
		List<ProfileDTO> profiles = profileService.getAllProfiles();	
		
		return new ResponseEntity<List<ProfileDTO>>(profiles,profiles.size()>0 ? HttpStatus.OK:HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping("/skill-tracker/api/v1/engineer/add-profile")
	public ResponseEntity<?> createProfile(@RequestBody ProfileDTO profile){
		try {
			profileService.CreateProfile(profile);
			return new ResponseEntity<>(profile,HttpStatus.OK);
		}catch(ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		} catch(profileException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	

	@GetMapping("/skill-tracker/api/v1/admin/ID/{id}")
	public ResponseEntity<?> getProfilebyID(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(profileService.getProfile(id),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/skill-tracker/api/v1/admin/names/{name}")
	public ResponseEntity<?> getProfilesbyStartingName(@PathVariable("name") String name){
		try {
			return new ResponseEntity<>(profileService.getProfilesByName(name),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/skill-tracker/api/v1/admin/skill/{skill}")
	public ResponseEntity<?> getProfilesbySkillMatched(@PathVariable("skill") String skill){
		try {
			return new ResponseEntity<>(profileService.getProfilesByMentionedSkill(skill),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/skill-tracker/api/v1/engineer/update-profile/{id}")
	public ResponseEntity<?> updateProfilebyID(@PathVariable("id") String id,@RequestBody ProfileDTO newProfile){
		try {
			profileService.updateProfile(id, newProfile);
			return new ResponseEntity<>("Profile updated with id "+id,HttpStatus.OK);
		}catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		}catch(profileException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/skill-tracker/api/v1/admin/delete-profile/{id}")
	public ResponseEntity<?> deleteByID(@PathVariable("id") String id){
		try {
			profileService.deleteProfile(id);
			return new ResponseEntity<>("Successfuly deleted with ID "+id,HttpStatus.OK);
		} catch (profileException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}


//@Autowired
//private ProfileRepository profileRepo;

//@GetMapping("/profiles")
//public ResponseEntity<?> getAllProfiles(){
//	List<ProfileDTO> profiles = profileRepo.findAll();	
//	if(profiles.size()>0) {
//		return new ResponseEntity<List<ProfileDTO>>(profiles,HttpStatus.OK);
//	}else {
//		return new ResponseEntity<>("No profiles available",HttpStatus.NOT_FOUND);
//	}
//}


//@PostMapping("/profiles")
//public ResponseEntity<?> createProfile(@RequestBody ProfileDTO profile){
//	try {
//		profile.setCreatedAt(new Date(System.currentTimeMillis()));
//		profile.setId();
//		profileRepo.save(profile);
//		return new ResponseEntity<>(profile,HttpStatus.OK);
//	}catch(Exception e) {
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//}

//@GetMapping("/profiles/{id}")
//public ResponseEntity<?> getProfilebyID(@PathVariable("id") String id){
//	Optional<ProfileDTO> profile = profileRepo.findById(id);
//	if(profile.isPresent()) {
//		return new ResponseEntity<>(profile.get(),HttpStatus.OK);
//	}else {
//		return new ResponseEntity<>("No profiles available with id "+id,HttpStatus.NOT_FOUND);
//	}
//}

//@PutMapping("/profiles/{id}")
//public ResponseEntity<?> updateProfilebyID(@PathVariable("id") String id,@RequestBody ProfileDTO newProfile){
//	Optional<ProfileDTO> profileO = profileRepo.findById(id);
//	if(profileO.isPresent()) {
////		System.out.println(newProfile.getAngular());
//		ProfileDTO profile = profileO.get();
//		profile.setAngular(newProfile.getAngular()>0?newProfile.getAngular():profile.getAngular());
//		profile.setAws(newProfile.getAws()>0 ? newProfile.getAws():profile.getAws());
//		profile.setDocker(newProfile.getDocker()>0?newProfile.getDocker():profile.getDocker());
//		profile.setGit(newProfile.getGit()>0?newProfile.getGit():profile.getDocker());
//		profile.setHibernate(newProfile.getHibernate()>0?newProfile.getHibernate():profile.getHibernate());
//		profile.setHtml_css_javascript(newProfile.getHtml_css_javascript()>0?newProfile.getHtml_css_javascript():profile.getHtml_css_javascript());
//		profile.setJenkins(newProfile.getJenkins()>0?newProfile.getJenkins():profile.getJenkins());
//		profile.setReact(newProfile.getReact()>0?newProfile.getReact():profile.getReact());
//		profile.setRestful(newProfile.getRestful()>0?newProfile.getRestful():profile.getRestful());
//		profile.setSpring(newProfile.getSpring()>0?newProfile.getSpring():profile.getSpring());
//		
//		profile.setSpoken(newProfile.getSpoken()>0?newProfile.getSpoken():profile.getSpoken());
//		profile.setCommunication(newProfile.getCommunication()>0?newProfile.getCommunication():profile.getCommunication());
//		profile.setAptitude(newProfile.getAptitude()>0?newProfile.getAptitude():profile.getAptitude());
//				
//		profile.setUpdatedAt(new Date(System.currentTimeMillis()));
//		
//		profileRepo.save(profile);
//		return new ResponseEntity<>(profileO.get(),HttpStatus.OK);
//	}else {
//		return new ResponseEntity<>("No profiles available with id "+id,HttpStatus.NOT_FOUND);
//	}
//}

//@DeleteMapping("profiles/{id}")
//public ResponseEntity<?> deleteByID(@PathVariable("id") String id){
//	try {
//		profileRepo.deleteById(id);
//		return new ResponseEntity<>("Successfuly deleted with ID "+id,HttpStatus.OK);
//	} catch (Exception e) {
//		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//	}
//}

