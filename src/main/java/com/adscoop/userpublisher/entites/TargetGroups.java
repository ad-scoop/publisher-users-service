package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by thokle on 25/08/2016.
 */
public class TargetGroups extends AbstratEntity {

	private String gender;
	private int from;
	private int to;

	@Labels
	private List<String> labels = new ArrayList<>();

	@Relationship(type = "WEBSITE_TARGETGROUPT", direction = Relationship.INCOMING)
	private Set<WebSite> websiteNodes = new HashSet<>();

	@Relationship(direction = Relationship.INCOMING, type = "TARGET_BELONGS_TO_BANNER")
	private Set<Banner> tarbannerNodes = new HashSet<>();

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public Set<Banner> getTarbannerNodes() {
		return tarbannerNodes;
	}

	public void setTarbannerNodes(Set<Banner> tarbannerNodes) {
		this.tarbannerNodes = tarbannerNodes;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public Set<WebSite> getWebsiteNodes() {
		return websiteNodes;
	}

	public void setWebsiteNodes(Set<WebSite> websiteNodes) {
		this.websiteNodes = websiteNodes;
	}
	
}
