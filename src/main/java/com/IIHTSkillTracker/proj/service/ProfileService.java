package com.IIHTSkillTracker.proj.service;

import javax.validation.ConstraintViolationException;

import com.IIHTSkillTracker.proj.exception.profileException;
import com.IIHTSkillTracker.proj.model.ProfileDTO;

public interface ProfileService {
	public void CreateProfile(ProfileDTO profile) throws ConstraintViolationException,profileException;
}
