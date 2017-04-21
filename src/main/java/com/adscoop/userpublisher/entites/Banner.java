package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Banner extends AbstratEntity {

	private Integer width;
	private Integer height;
	private Integer clicks;
	private String picture;

	@Labels
	private List<String> labels = new ArrayList<>();

	private List<Long> bannerSpaceIds = new ArrayList<>();

	@Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_BANNERS")
	@JsonBackReference
	private List<Campagin> campagin = new ArrayList<>();

}
