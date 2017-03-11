package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by thokle on 25/08/2016.
 */
@NodeEntity
public class Regions extends AbstratEntity {

    @Labels
    private List<String> labels = new ArrayList<>();

    @Relationship(type = "REGION_BELONGS_TO_BANNER_SPACE")
    private Set<BannerSpace>  bannerSpaces = new HashSet<>();

    @Relationship(type = "REGION_BELONGS_TO_WEBSITE")
    private Set<WebSite> webSiteNodes = new HashSet<>();

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    @JsonIgnore
    public Set<BannerSpace> getBannerSpaces() {
        return bannerSpaces;
    }

    public void setBannerSpaces(Set<BannerSpace> bannerSpaces) {
        this.bannerSpaces = bannerSpaces;
    }

    @JsonIgnore
    public Set<WebSite> getWebSiteNodes() {
        return webSiteNodes;
    }

    public void setWebSiteNodes(Set<WebSite> webSiteNodes) {
        this.webSiteNodes = webSiteNodes;
    }
}
