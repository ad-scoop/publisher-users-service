package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Campagin extends AbstratEntity {

	private String name;
	private long startDate;
	private long endDate;
	private double maxPricePrDay;
	private long clicks;
	private String token;
	
	@Builder.Default
	private List<Long> webSiteIds = new ArrayList<>();

	@Relationship(type = "CAMPAGIN_HAS_BANNERS")
	@Builder.Default
	private List<Banner> banners = new ArrayList<>();

}
