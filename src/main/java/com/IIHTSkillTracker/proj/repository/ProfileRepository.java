package com.IIHTSkillTracker.proj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.IIHTSkillTracker.proj.model.ProfileDTO;

public interface ProfileRepository extends MongoRepository<ProfileDTO,String>{
	
	List<ProfileDTO> findByNameStartsWithIgnoreCase(String name);
	List<ProfileDTO> findByHibernateGreaterThanOrderByHibernateDesc(int value);
	List<ProfileDTO> findByAptitudeGreaterThanOrderByAptitudeDesc(int value);
	List<ProfileDTO> findByCommunicationGreaterThanOrderByCommunicationDesc(int value);
	List<ProfileDTO> findBySpokenGreaterThanOrderBySpokenDesc(int value);
	List<ProfileDTO> findByAwsGreaterThanOrderByAwsDesc(int value);
	List<ProfileDTO> findByJenkinsGreaterThanOrderByJenkinsDesc(int value);
	List<ProfileDTO> findByDockerGreaterThanOrderByDockerDesc(int value);
	List<ProfileDTO> findByGitGreaterThanOrderByGitDesc(int value);
	List<ProfileDTO> findByRestfulGreaterThanOrderByRestfulDesc(int value);
	List<ProfileDTO> findBySpringGreaterThanOrderBySpringDesc(int value);
	List<ProfileDTO> findByReactGreaterThanOrderByReactDesc(int value);
	List<ProfileDTO> findByAngularGreaterThanOrderByAngularDesc(int value);
	List<ProfileDTO> findByHtmlcssjavascriptGreaterThanOrderByHtmlcssjavascriptDesc(int value);
//	repository.findByNameStartsWith(token, new PageRequest(0,10));

}
