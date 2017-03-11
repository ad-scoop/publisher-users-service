package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by thokle on 24/08/2016.
 */

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Banner extends AbstratEntity {

	private String positionSiteM;
	private String positionSiteL;
	private String uniqeToken;
	private Integer width;
	private Integer height;
	private Integer clicks;
	private String picture;
	private String counterUrl;

	@Labels
	private List<String> labels = new ArrayList<>();

//	@Relationship(type = "HAS_CATEGORIES")
//	private Set<Category> categories = new HashSet<>();
//
//	@Relationship(type = "HAS_TARGETGROUPS")
//	private Set<TargetGroups> targetGroupses = new HashSet<>();
//
//	@Relationship(type = "HAS_FOOTPRINT")
//	private Set<FootPrintInfo> footPrintInfo = new HashSet<>();

	@Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_BANNERS")
	@JsonBackReference
	private Campagin campagin;

	public String getPositionSiteM() {
		return positionSiteM;
	}

	public void setPositionSiteM(String positionSiteM) {
		this.positionSiteM = positionSiteM;
	}

	public String getPositionSiteL() {
		return positionSiteL;
	}

	public void setPositionSiteL(String positionSiteL) {
		this.positionSiteL = positionSiteL;
	}

	public String getUniqeToken() {
		return uniqeToken;
	}

	public void setUniqeToken(String uniqeToken) {
		this.uniqeToken = uniqeToken;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getCounterUrl() {
		return counterUrl;
	}

	public void setCounterUrl(String counterUrl) {
		this.counterUrl = counterUrl;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setLabel(String label) {
		this.labels.add(label);
	}


	public Campagin getCampagin() {
		return campagin;
	}

	public void setCampagin(Campagin campagin) {
		this.campagin = campagin;
	}

//	public Set<FootPrintInfo> getFootPrintInfo() {
//		return footPrintInfo;
//	}
//
//	public void setFootPrintInfo(FootPrintInfo footPrintInfo) {
//		this.footPrintInfo.add(footPrintInfo);
//	}

//	public void addFootPrint(FootPrintInfo footPrintInformationNode) {
//		footPrintInfo.add(footPrintInformationNode);
//		footPrintInformationNode.setBannerNode(this);
//	}

//	public void addCategory(Category category) {
//		categories.add(category);
//		category.getCatbannerNodes().add(this);
//	}
//
//	public String getBannerSpaceToken() {
//		return bannerSpaceToken;
//	}
//
//	public void setBannerSpaceToken(String bannerSpaceToken) {
//		this.bannerSpaceToken = bannerSpaceToken;
//	}
//
//	public Set<Category> getCategories() {
//		return categories;
//	}
//
//	public void setCategories(Set<Category> categories) {
//		this.categories = categories;
//	}
//
//	public Set<TargetGroups> getTargetGroupses() {
//		return targetGroupses;
//	}
//
//	public void setTargetGroupses(Set<TargetGroups> targetGroupses) {
//		this.targetGroupses = targetGroupses;
//	}
}
