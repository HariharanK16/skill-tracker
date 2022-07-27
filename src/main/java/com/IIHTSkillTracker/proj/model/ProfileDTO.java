package com.IIHTSkillTracker.proj.model;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProfileDTO {
	@Id
	@Size(max=30,min=5,message="ID length should be between 5-30")
	@NotNull(message = "ID Cannot be null")
	private String id;
	
	@Size(max=30,min=5,message="Name length should be between 5-30")
	@NotNull(message = "Name Cannot be null")
	private String name;
	
	@Email(message = "Email ID is not valid",regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	@NotNull(message = "Email Cannot be null")
	private String email;
	
	@Size(max=10,min=10,message="Number length should be 10")
	@NotNull(message = "Mobile Cannot be null")
	private String mobile;
	
	@NotNull(message = "Role Cannot be null")
	private String role;
	
	@NotNull(message = "DOB Cannot be null")
	private String dob;
	
	private Date createdAt;
	private Date updatedAt;
	
	@Min(0) 
	@Max(20)
	private int html_css_javascript;
	
	@Min(0) 
	@Max(20)
	private int angular;
	
	@Min(0) 
	@Max(20)
	private int react;
	
	@Min(0) 
	@Max(20)
	private int spring;
	
	@Min(0) 
	@Max(20)
	private int restful;
	
	@Min(0) 
	@Max(20)
	private int hibernate;
	
	@Min(0) 
	@Max(20)
	private int git;
	
	@Min(0) 
	@Max(20)
	private int docker;
	
	@Min(0) 
	@Max(20)
	private int jenkins;
	
	@Min(0) 
	@Max(20)
	private int aws;
	
	@Min(0) 
	@Max(20)
	private int spoken;
	
	@Min(0) 
	@Max(20)
	private int communication;
	
	@Min(0) 
	@Max(20)
	private int aptitude;

	public String getId() {
		return id;
	}
	public void setId() {
		this.id = "CTS-"+this.name+"-"+this.dob.replaceAll("[^a-zA-Z0-9]", "");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getHtml_css_javascript() {
		return html_css_javascript;
	}
	public void setHtml_css_javascript(int html_css_javascript) {
		this.html_css_javascript = html_css_javascript;
	}
	public int getAngular() {
		return angular;
	}
	public void setAngular(int angular) {
		this.angular = angular;
	}
	public int getReact() {
		return react;
	}
	public void setReact(int react) {
		this.react = react;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public int getRestful() {
		return restful;
	}
	public void setRestful(int restful) {
		this.restful = restful;
	}
	public int getHibernate() {
		return hibernate;
	}
	public void setHibernate(int hibernate) {
		this.hibernate = hibernate;
	}
	public int getGit() {
		return git;
	}
	public void setGit(int git) {
		this.git = git;
	}
	public int getDocker() {
		return docker;
	}
	public void setDocker(int docker) {
		this.docker = docker;
	}
	public int getJenkins() {
		return jenkins;
	}
	public void setJenkins(int jenkins) {
		this.jenkins = jenkins;
	}
	public int getAws() {
		return aws;
	}
	public void setAws(int aws) {
		this.aws = aws;
	}
	public int getSpoken() {
		return spoken;
	}
	public void setSpoken(int spoken) {
		this.spoken = spoken;
	}
	public int getCommunication() {
		return communication;
	}
	public void setCommunication(int communication) {
		this.communication = communication;
	}
	public int getAptitude() {
		return aptitude;
	}
	public void setAptitude(int aptitude) {
		this.aptitude = aptitude;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
