package com.IIHTSkillTracker.proj.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
				profile.setHtmlcssjavascript(newProfile.getHtmlcssjavascript()>0?newProfile.getHtmlcssjavascript():profile.getHtmlcssjavascript());
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

	@Override
	public List<ProfileDTO> getProfilesByName(String name) throws profileException {
		List<ProfileDTO> profiles = profileRepo.findByNameStartsWithIgnoreCase(name);
		if(profiles.size()>0) {
			return profiles;
		}else {
			throw new profileException(profileException.NotFoundExceptionByName(name));
		}
	}

	@Override
	public List<ProfileDTO> getProfilesByMentionedSkill(String skill) throws profileException {
		// TODO Auto-generated method stub
		List<ProfileDTO> profiles = new ArrayList<ProfileDTO>();
		switch (skill) {
	        case "htmlcssjavascript":
	        	profiles.addAll(profileRepo.findByHtmlcssjavascriptGreaterThanOrderByHtmlcssjavascriptDesc(10));
//	            System.out.println("html");
	            break;
	        case "angular":
	        	profiles.addAll(profileRepo.findByAngularGreaterThanOrderByAngularDesc(10));
//	        	System.out.println("angular");
	            break;
	        case "react":
	        	profiles.addAll(profileRepo.findByReactGreaterThanOrderByReactDesc(10));
//	            System.out.println("react");
	            break;
	        case "spring":
	        	profiles.addAll(profileRepo.findBySpringGreaterThanOrderBySpringDesc(10));
//	            System.out.println("spring");
	            break;
	        case "restful":
	        	profiles.addAll(profileRepo.findByRestfulGreaterThanOrderByRestfulDesc(10));
//	        	System.out.println("restful");
	            break;
	        case "hibernate":
	        	profiles.addAll(profileRepo.findByHibernateGreaterThanOrderByHibernateDesc(10));
//	            System.out.println("hibernate");
	            break;
	        case "git":
	        	profiles.addAll(profileRepo.findByGitGreaterThanOrderByGitDesc(10));
//	            System.out.println("git");
	            break;
	        case "docker":
	        	profiles.addAll(profileRepo.findByDockerGreaterThanOrderByDockerDesc(10));
//	        	System.out.println("docker");
	            break;
	        case "jenkins":
	        	profiles.addAll(profileRepo.findByJenkinsGreaterThanOrderByJenkinsDesc(10));
//	            System.out.println("jenkins");
	            break;
	        case "aws":
	        	profiles.addAll(profileRepo.findByAwsGreaterThanOrderByAwsDesc(10));
//	            System.out.println("aws");
	            break;
	        case "spoken":
	        	profiles.addAll(profileRepo.findBySpokenGreaterThanOrderBySpokenDesc(10));
//	        	System.out.println("spoken");
	            break;
	        case "communication":
	        	profiles.addAll(profileRepo.findByCommunicationGreaterThanOrderByCommunicationDesc(10));
//	            System.out.println("communication");
	            break;
	        case "aptitude":
	        	profiles.addAll(profileRepo.findByAptitudeGreaterThanOrderByAptitudeDesc(10));
//	            System.out.println("aptitude");
	            break;
	        default:
	        	break;
//	            throw new profileException(profileException.NoMatchFoundException(skill));
        }
		if(profiles.size()>0) {
			return profiles;
		}else {
			throw new profileException(profileException.NoMatchFoundException(skill));
		}
	}
	
}
