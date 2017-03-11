package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by thokle on 18/10/2016.
 */
@NodeEntity
public class WebSite extends AbstratEntity {

	private int port;
	private String hostname;
	private String path;

	@Relationship(type = "WEBSITE_REGIONS", direction = Relationship.INCOMING)
	@JsonBackReference
	private Campagin campagin;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Campagin getCampagin() {
		return campagin;
	}

	public void setCampagin(Campagin campagin) {
		this.campagin = campagin;
	}

}
