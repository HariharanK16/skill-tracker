package com.IIHTSkillTracker.proj.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.IIHTSkillTracker.proj.exception.profileException;
import com.IIHTSkillTracker.proj.model.ProfileDTO;

public interface ProfileService {
	
	public void CreateProfile(ProfileDTO profile) throws ConstraintViolationException,profileException;
	
	public List<ProfileDTO> getAllProfiles();

	public ProfileDTO getProfile(String id) throws profileException;
	
	public void updateProfile(String id,ProfileDTO dto) throws profileException;
	
	public void deleteProfile(String id) throws profileException;
	
	public List<ProfileDTO> getProfilesByName(String name) throws profileException;
	
	public List<ProfileDTO> getProfilesByMentionedSkill(String skill) throws profileException;
}
