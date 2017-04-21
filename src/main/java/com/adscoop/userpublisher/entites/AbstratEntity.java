package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.GraphId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public abstract class AbstratEntity {

	@GraphId
	@JsonProperty("id")
	private Long id;

}
