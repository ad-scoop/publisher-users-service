package com.adscoop.userpublisher.entites;



import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;

@Getter @Setter
public abstract class AbstratEntity {

	@GraphId
	private Long id;

}
