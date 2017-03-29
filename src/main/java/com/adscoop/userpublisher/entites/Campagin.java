package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Created by thokle on 12/02/2017.
 */

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Campagin extends AbstratEntity {


	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private long startDate;
	@Getter
	@Setter
	private long endDate;
	@Getter
	@Setter
	private double maxPricePrDay;


	@Getter
	@Setter
	@Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_USER")
	@JsonBackReference
	private UserNode userNode;

	@Getter
	@Setter
	@Relationship(type = "CAMPAGIN_HAS_BANNERS")

	private List<Banner> banners = new ArrayList<>();

	@Relationship(type = "RESERVED_WEBSITES")
	@JsonManagedReference
	private List<WebSite> webSites = new ArrayList<>();



	public void addBanner(Banner bannerNode) {
		banners.add(bannerNode);
		bannerNode.getCampagin().add(this);
	}

	public void addReservedWebSite(WebSite webSite) {
		webSites.add(webSite);
		webSite.setCampagin(this);
	}

	public String getName() {
		return name;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

}
