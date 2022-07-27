package com.IIHTSkillTracker.proj.service;

import java.util.Date;
import java.util.Optional;

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
	
}
