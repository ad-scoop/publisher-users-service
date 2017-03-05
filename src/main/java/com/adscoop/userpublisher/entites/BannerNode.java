package com.adscoop.userpublisher.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by thokle on 24/08/2016.
 */

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class BannerNode extends Entity {

	private String positionSiteM;
	private String positionSiteL;
	private String uniqeToken;
	private Integer width;
	private Integer height;
	private Integer clicks;
	private String bannerSpaceToken;
	private String picture;
	private String counterUrl;

	@Labels
	private List<String> labels = new ArrayList<>();

	@Relationship(type = "HAS_CATEGORIES", direction = Relationship.OUTGOING)
	private Set<Category> categories = new HashSet<>();

	@Relationship(type = "HAS_TARGETGROUPS", direction = Relationship.OUTGOING)
	private Set<TargetGroups> targetGroupses = new HashSet<>();

	@Relationship(type = "HAS_FOOTPRINT", direction = Relationship.OUTGOING)
	private Set<FootPrintInformationNode> footPrintInformationNodes = new HashSet<>();

	@JsonIgnore
	@Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_BANNERS")
	private Set<Campagin> nodes = new HashSet<>();

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

	public Set<FootPrintInformationNode> getFootPrintInformationNodes() {
		return footPrintInformationNodes;
	}

	public void setFootPrintInformationNodes(FootPrintInformationNode footPrintInformationNodes) {
		this.footPrintInformationNodes.add(footPrintInformationNodes);
	}

	public void setLabel(String label) {
		this.labels.add(label);
	}

	public void addFootPrint(FootPrintInformationNode footPrintInformationNode) {
		footPrintInformationNodes.add(footPrintInformationNode);
		footPrintInformationNode.getBannerNodeSet().add(this);
	}

	public void addCategory(Category category) {
		categories.add(category);
		category.getCatbannerNodes().add(this);
	}

	public String getBannerSpaceToken() {
		return bannerSpaceToken;
	}

	public void setBannerSpaceToken(String bannerSpaceToken) {
		this.bannerSpaceToken = bannerSpaceToken;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<TargetGroups> getTargetGroupses() {
		return targetGroupses;
	}

	public void setTargetGroupses(Set<TargetGroups> targetGroupses) {
		this.targetGroupses = targetGroupses;
	}

	public Set<Campagin> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Campagin> nodes) {
		this.nodes = nodes;
	}

}
