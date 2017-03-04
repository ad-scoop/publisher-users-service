package com.adscoop.userpublisher.entites;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by thokle on 12/02/2017.
 */

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Campagin extends Entity {

	private String name;
	private Date startDate;
	private Date endDate;
	private double maxPricePrDay;

	@Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_USER")
	private Set<UserNode> userNodes = new HashSet<>();

	@Relationship(direction = Relationship.OUTGOING, type = "CAMPAGIN_HAS_BANNERS")
	private Set<BannerNode> banners = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<UserNode> getUserNodes() {
		return userNodes;
	}

	public void setUserNodes(Set<UserNode> userNodes) {
		this.userNodes = userNodes;
	}

	public Set<BannerNode> getBanners() {
		return banners;
	}

	public void setBanners(Set<BannerNode> banners) {
		this.banners = banners;
	}

	public void addBanner(BannerNode bannerNode) {
		banners.add(bannerNode);
		bannerNode.getNodes().add(this);

	}

	public double getMaxPricePrDay() {
		return maxPricePrDay;
	}

	public void setMaxPricePrDay(double maxPricePrDay) {
		this.maxPricePrDay = maxPricePrDay;
	}
}
