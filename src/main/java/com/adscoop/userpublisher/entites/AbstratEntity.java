package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.GraphId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public abstract class AbstratEntity {

	@GraphId
	private Long id;

}
