package com.adscoop.userpublisher.entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thokle on 24/08/2016.
 */
@NodeEntity
public class UserNode extends AbstratEntity {

    @Getter
    @Setter
    private boolean isActivated;
    @Getter
    @Setter
    private String firstname;
    @Getter
    @Setter
    private String middlename;
    @Getter
    @Setter
    private String lastname;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private List<String> labels = new ArrayList<>();

    @Getter
    @Setter
    @Relationship(type = "CAMPAGIN_HAS_USER", direction = Relationship.OUTGOING)
    @JsonManagedReference
    private List<Campagin> campagins = new ArrayList<>();


    public void addCampagin(Campagin campagin) {
        this.campagins.add(campagin);
        campagin.setUserNode(this);
    }

    public void removeCampagin(String name) {
        this.campagins.removeIf(campagin -> campagin.getName().equals(name));
    }

}
