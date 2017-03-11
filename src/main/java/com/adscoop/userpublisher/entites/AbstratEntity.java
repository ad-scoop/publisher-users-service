package com.adscoop.userpublisher.entites;

import org.neo4j.ogm.annotation.GraphId;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by thokle on 24/08/2016.
 */
public abstract class AbstratEntity {


    @GraphId
    @JsonProperty("id")
    private Long id;

    public AbstratEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstratEntity other = (AbstratEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}
