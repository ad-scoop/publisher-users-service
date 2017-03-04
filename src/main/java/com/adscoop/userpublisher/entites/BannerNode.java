package com.adscoop.userpublisher.entites;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by thokle on 24/08/2016.
 */

@NodeEntity
public class BannerNode extends Entity {

	private String domain;
	private String positionSiteM;
	private String positionSiteL;
	private String url;
	private String uniqeToken;
	private Integer lenght;
	private Integer height;
	private String counterUrl;
	private Integer counter;
	private String bannerSpaceToken;
	private String pictureUrl;
	private String filetype;

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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		url = url;
	}

	public String getUniqeToken() {
		return uniqeToken;
	}

	public void setUniqeToken(String uniqeToken) {
		this.uniqeToken = uniqeToken;
	}

	public Integer getLenght() {
		return lenght;
	}

	public void setLenght(Integer lenght) {
		this.lenght = lenght;
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

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
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

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
}
