package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
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


	@Getter
	@Setter
	private String positionSiteM;
	@Getter
	@Setter
	private String positionSiteL;
	@Getter
	@Setter
	private String uniqeToken;
	@Getter
	@Setter
	private Integer width;
	@Getter
	@Setter
	private Integer height;
	@Getter
	@Setter
	private Integer clicks;
	@Getter
	@Setter
	private String picture;
	@Getter
	@Setter
	private String counterUrl;

	@Getter
	@Setter
	@Labels
	private List<String> labels = new ArrayList<>();



	@Getter
	@Setter
	@Relationship(direction = Relationship.INCOMING, type = "CAMPAGIN_HAS_BANNERS")
	@JsonBackReference
	private List<Campagin> campagin = new ArrayList<>();

}
