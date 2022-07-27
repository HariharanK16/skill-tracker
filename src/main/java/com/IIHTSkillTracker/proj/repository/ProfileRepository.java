package com.IIHTSkillTracker.proj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.IIHTSkillTracker.proj.model.ProfileDTO;

public interface ProfileRepository extends MongoRepository<ProfileDTO,String>{

}
