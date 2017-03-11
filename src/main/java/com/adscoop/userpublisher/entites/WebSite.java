package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by thokle on 18/10/2016.
 */
@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSite extends AbstratEntity {

	private int port;
	private String url;
	private String name;
	private String industry;
	private String zip;

	@Relationship(type = "WEBSITE_REGIONS", direction = Relationship.INCOMING)
	@JsonBackReference
	private Campagin campagin;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Campagin getCampagin() {
		return campagin;
	}

	public void setCampagin(Campagin campagin) {
		this.campagin = campagin;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
