package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by thokle on 12/02/2017.
 */

@NodeEntity
public class Campagin extends  Entity {

    private String campagin_name;

    private String startDate;
    private String endDate;

    private double maxPricePrDay;


    @Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_USER")
    private Set<UserNode>  userNodes  = new HashSet<>();


    @Relationship(direction = Relationship.OUTGOING, type="CAMPAGIN_HAS_BANNERS")
    private  Set<BannerNode>  nodes = new HashSet<>();


    @Relationship(direction = Relationship.OUTGOING, type = "RESERVED_WEBSITES")
    private Set<WebSiteNode> webSiteNodes = new HashSet<>();

    public String getCampagin_name() {
        return campagin_name;
    }

    public void setCampagin_name(String campagin_name) {
        this.campagin_name = campagin_name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Set<UserNode> getUserNodes() {
        return userNodes;
    }

    public void setUserNodes(Set<UserNode> userNodes) {
        this.userNodes = userNodes;
    }

    public Set<BannerNode> getNodes() {
        return nodes;
    }

    public void setNodes(Set<BannerNode> nodes) {
        this.nodes = nodes;
    }


    public   void addReservedWebSite(WebSiteNode webSiteNode){
        webSiteNodes.add(webSiteNode);
        webSiteNode.getCampaginList().add(this);
    }


    public void addBanner(BannerNode bannerNode) {
            nodes.add(bannerNode);
            bannerNode.getNodes().add(this);

    }
}
