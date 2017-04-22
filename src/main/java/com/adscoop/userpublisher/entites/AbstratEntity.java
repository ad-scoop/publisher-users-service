package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.GraphId;

import lombok.Data;

@Data
public abstract class AbstratEntity {

	@GraphId
	private Long id;

}
