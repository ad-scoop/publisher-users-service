package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Created by thokle on 24/08/2016.
 */
@NodeEntity
public class UserNode extends AbstratEntity {

	private boolean isActivated;
	private String firstname;
	private String middlename;
	private String lastname;
	private String username;
	private String email;
	private String password;
	private String token;

	@Labels
	private List<String> labels = new ArrayList<>();

	@Relationship(type = "CAMPAGIN_HAS_USER")
	@JsonManagedReference
	private Set<Campagin> campagins = new HashSet<>();

	public Set<Campagin> getCampagins() {
		return campagins;
	}

	public void setCampagins(Set<Campagin> campagins) {
		this.campagins = campagins;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public void setLabel(String s) {
		this.labels.add(s);
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean activated) {
		isActivated = activated;
	}

	public void addCampagin(Campagin campagin) {
		this.campagins.add(campagin);
		campagin.setUserNode(this);
	}

	public void removeCampagin(String name) {
		this.campagins.removeIf(campagin -> campagin.getName().equals(name));
	}

}
