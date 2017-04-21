package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode(callSuper=true)
public class Campagin extends AbstratEntity {

	private String name;
	private long startDate;
	private long endDate;
	private double maxPricePrDay;
	private long clicks;
	private String token;
	
	private List<Long> webSiteIds = new ArrayList<>();

	@Relationship(type = "CAMPAGIN_HAS_BANNERS")
	private List<Banner> banners = new ArrayList<>();

}
