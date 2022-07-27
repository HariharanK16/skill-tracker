package com.IIHTSkillTracker.proj.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IIHTSkillTracker.proj.exception.profileException;
import com.IIHTSkillTracker.proj.model.ProfileDTO;
import com.IIHTSkillTracker.proj.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepo;
	
	@Override
	public void CreateProfile(ProfileDTO profile) throws ConstraintViolationException, profileException {
		// TODO Auto-generated method stub
		String id = "CTS-"+profile.getName()+"-"+profile.getDob().replaceAll("[^a-zA-Z0-9]", "");
		Optional<ProfileDTO> profileCheck = profileRepo.findById(id);
		if(profileCheck.isPresent()) {
			throw new profileException(profileException.ProfileAlreadyExists());
		}else {
			profile.setCreatedAt(new Date(System.currentTimeMillis()));
			profile.setId();
			
			profileRepo.save(profile);
		}
	}

	@Override
	public List<ProfileDTO> getAllProfiles() {
		// TODO Auto-generated method stub
		
		List<ProfileDTO> profiles = profileRepo.findAll();
		
		if(profiles.size()>0) {
			return profiles;
		}else {
			return new ArrayList<ProfileDTO>();
		}
	}

	@Override
	public ProfileDTO getProfile(String id) throws profileException {
		// TODO Auto-generated method stub
		
		Optional<ProfileDTO> profileFind = profileRepo.findById(id);
		if(!profileFind.isPresent()) {
			throw new profileException(profileException.NotFoundException(id));
		}else {
			return profileFind.get();
		}
	}

	@Override
	public void updateProfile(String id, ProfileDTO newProfile) throws profileException {
		Optional<ProfileDTO> profileFind = profileRepo.findById(id);
		if(profileFind.isPresent()) {
			ProfileDTO profile = profileFind.get();
			Date currTime = new Date(System.currentTimeMillis());
			long diff = currTime.getTime() - profile.getUpdatedAt().getTime();

	        TimeUnit time = TimeUnit.DAYS; 
	        long difference = time.convert(diff, TimeUnit.MILLISECONDS);
//	        System.out.println("The difference in days is : "+difference);
	        
			if(profile.getUpdatedAt()==null || difference>10) {
				profile.setAngular(newProfile.getAngular()>0?newProfile.getAngular():profile.getAngular());
				profile.setAws(newProfile.getAws()>0 ? newProfile.getAws():profile.getAws());
				profile.setDocker(newProfile.getDocker()>0?newProfile.getDocker():profile.getDocker());
				profile.setGit(newProfile.getGit()>0?newProfile.getGit():profile.getDocker());
				profile.setHibernate(newProfile.getHibernate()>0?newProfile.getHibernate():profile.getHibernate());
				profile.setHtml_css_javascript(newProfile.getHtml_css_javascript()>0?newProfile.getHtml_css_javascript():profile.getHtml_css_javascript());
				profile.setJenkins(newProfile.getJenkins()>0?newProfile.getJenkins():profile.getJenkins());
				profile.setReact(newProfile.getReact()>0?newProfile.getReact():profile.getReact());
				profile.setRestful(newProfile.getRestful()>0?newProfile.getRestful():profile.getRestful());
				profile.setSpring(newProfile.getSpring()>0?newProfile.getSpring():profile.getSpring());
				
				profile.setSpoken(newProfile.getSpoken()>0?newProfile.getSpoken():profile.getSpoken());
				profile.setCommunication(newProfile.getCommunication()>0?newProfile.getCommunication():profile.getCommunication());
				profile.setAptitude(newProfile.getAptitude()>0?newProfile.getAptitude():profile.getAptitude());
						
				profile.setUpdatedAt(new Date(System.currentTimeMillis()));
				
				profileRepo.save(profile);
			}else {
				throw new profileException(profileException.ProfileCannotBeUpdated(id));
			}
		}else {
			throw new profileException(profileException.NotFoundException(id));
		}
	}

	@Override
	public void deleteProfile(String id) throws profileException {
		// TODO Auto-generated method stub
		Optional<ProfileDTO> profile = profileRepo.findById(id);
		if(profile.isPresent()) {
			profileRepo.delete(profile.get());
		}else {
			throw new profileException(profileException.NotFoundException(id));
		}
	}
	
}
