package com.adscoop.userpublisher.entites;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by thokle on 09/10/2016.
 */
@NodeEntity
public class FootPrintInfo extends AbstratEntity {

	@Labels
	private List<String> list = new ArrayList<>();

	@Relationship(type = "BELONGS_TO_BANNER", direction = Relationship.INCOMING)
	private Banner bannerNode;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Banner getBannerNode() {
		return bannerNode;
	}

	public void setBannerNode(Banner bannerNode) {
		this.bannerNode = bannerNode;
	}

	public void setLabel(String s) {
		this.list.add(s);
	}
	
}
