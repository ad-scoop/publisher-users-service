package com.adscoop.userpublisher.entites;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by thokle on 12/02/2017.
 */

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Campagin extends AbstratEntity {

	private String name;
	private long startDate;
	private long endDate;
	private double maxPricePrDay;

	@Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_USER")
	@JsonBackReference
	private UserNode userNode;

	@Relationship(type = "CAMPAGIN_HAS_BANNERS")
	private Set<BannerNode> banners = new HashSet<>();

	@Relationship(type = "RESERVED_WEBSITES")
	private Set<WebSiteNode> webSiteNodes = new HashSet<>();

	public void setName(String name) {
		this.name = name;
	}

	public UserNode getUserNode() {
		return userNode;
	}

	public void setUserNode(UserNode userNode) {
		this.userNode = userNode;
	}

	public Set<BannerNode> getBanners() {
		return banners;
	}

	public void setBanners(Set<BannerNode> banners) {
		this.banners = banners;
	}

	public void addBanner(BannerNode bannerNode) {
		banners.add(bannerNode);
		bannerNode.setCampagin(this);
	}

	public void addReservedWebSite(WebSiteNode webSiteNode) {
		webSiteNodes.add(webSiteNode);
		webSiteNode.setCampagin(this);
	}

	public double getMaxPricePrDay() {
		return maxPricePrDay;
	}

	public void setMaxPricePrDay(double maxPricePrDay) {
		this.maxPricePrDay = maxPricePrDay;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDay(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public Set<WebSiteNode> getWebSiteNodes() {
		return webSiteNodes;
	}

	public void setWebSiteNodes(Set<WebSiteNode> webSiteNodes) {
		this.webSiteNodes = webSiteNodes;
	}

	public String getName() {
		return name;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

}
