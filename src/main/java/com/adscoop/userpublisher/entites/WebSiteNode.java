package com.adscoop.userpublisher.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thokle on 18/10/2016.
 */
@NodeEntity
public class WebSiteNode extends AbstratEntity {

	private int port;
	private String hostname;
	private String path;

	@Relationship(type = "WEBSITE_HAS_BANNERSPACE")
	private Set<BannerSpace> bannerSpaceSet = new HashSet<>();

	@Relationship(type = "USER_HAS_WEBSITE ", direction = Relationship.INCOMING)
	private Set<UserNode> userNodes = new HashSet<>();

	@Relationship(type = "WEBSITE_TARGETGROUPT")
	private Set<TargetGroups> targetGroupss = new HashSet<>();

	@Relationship(type = "WEBSITE_REGIONS")
	private Set<Regions> regionss = new HashSet<>();

	@Relationship(type = "WEBSITE_REGIONS", direction = Relationship.INCOMING)
	private Campagin campagin;

	private List<Company> companies = new ArrayList<>();

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

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

	public Set<BannerSpace> getBannerSpaceSet() {
		return bannerSpaceSet;
	}

	public void setBannerSpaceSet(Set<BannerSpace> bannerSpaceSet) {
		this.bannerSpaceSet = bannerSpaceSet;
	}

	@JsonIgnore
	public Set<UserNode> getUserNodes() {
		return userNodes;
	}

	public void setUserNodes(Set<UserNode> userNodes) {
		this.userNodes = userNodes;
	}

	public void addBannerSpace(BannerSpace bannerSpace) {
		bannerSpaceSet.add(bannerSpace);
		bannerSpace.getWebSiteNodeSet().add(this);
	}

	public Campagin getCampagin() {
		return campagin;
	}

	public void setCampagin(Campagin campagin) {
		this.campagin = campagin;
	}

	public void addTargetGroup(TargetGroups targetGroups) {
		targetGroupss.add(targetGroups);
		targetGroups.getWebsiteNodes().add(this);
	}

	public void addRegion(Regions regions) {
		regionss.add(regions);
		regions.getWebSiteNodes().add(this);

	}
}
