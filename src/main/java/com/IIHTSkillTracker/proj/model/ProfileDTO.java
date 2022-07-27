package com.IIHTSkillTracker.proj.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProfileDTO {
	@Id
	private String id;
	private String name;
	private String email;
	private String mobile;
	private String role;
	private String dob;
	
	private Date createdAt;
	private Date updatedAt;
	
	private int html_css_javascript;
	private int angular;
	private int react;
	private int spring;
	private int restful;
	private int hibernate;
	private int git;
	private int docker;
	private int jenkins;
	private int aws;
	
	private int spoken;
	private int communication;
	private int aptitude;

	public String getId() {
		return id;
	}
	public void setId() {
		this.id = this.name+this.dob.replaceAll("[^a-zA-Z0-9]", "");
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
