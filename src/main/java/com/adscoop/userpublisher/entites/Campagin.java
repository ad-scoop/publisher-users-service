package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by thokle on 12/02/2017.
 */

@NodeEntity
public class Campagin extends  Entity {

    private String campagin_name;

    private Date startDate;
    private Date endDate;



    @Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_USER")
    private Set<UserNode>  userNodes  = new HashSet<>();


    @Relationship(direction = Relationship.OUTGOING, type="CAMPAGIN_HAS_BANNERS")
    private  Set<BannerNode>  nodes = new HashSet<>();


    public String getCampagin_name() {
        return campagin_name;
    }

    public void setCampagin_name(String campagin_name) {
        this.campagin_name = campagin_name;
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

    public Set<BannerNode> getNodes() {
        return nodes;
    }

    public void setNodes(Set<BannerNode> nodes) {
        this.nodes = nodes;
    }


    public void addBanner(BannerNode bannerNode) {


    }
}
