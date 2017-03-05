package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by thokle on 12/02/2017.
 */

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Campagin extends Entity {

	private String name;

	private String startDay ;
	private String startMonth;
	private String startYear;

	private String endDay;
	private String endMonth;
	private String endYear;


	private double maxPricePrDay;

	@Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_USER")
	private Set<UserNode> userNodes = new HashSet<>();

	@Relationship(direction = Relationship.OUTGOING, type = "CAMPAGIN_HAS_BANNERS")
	private Set<BannerNode> banners = new HashSet<>();

	public String getName() {
		return name;
	}


    @Relationship(direction = Relationship.OUTGOING, type = "RESERVED_WEBSITES")
    private Set<WebSiteNode> webSiteNodes = new HashSet<>();


	public void setName(String name) {
		this.name = name;
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


    public   void addReservedWebSite(WebSiteNode webSiteNode){
        webSiteNodes.add(webSiteNode);
        webSiteNode.getCampaginList().add(this);
    }



	public double getMaxPricePrDay() {
		return maxPricePrDay;
	}


	public void setMaxPricePrDay(double maxPricePrDay) {
		this.maxPricePrDay = maxPricePrDay;
	}


	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
}
