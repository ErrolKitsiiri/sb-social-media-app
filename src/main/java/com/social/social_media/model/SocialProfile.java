package com.social.social_media.model;

import jakarta.persistence.*;


@Entity
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    //foreign key pointing to the id in the social_user table
    //but this class is the owner of the relationship
    @OneToOne
    @JoinColumn(name = "social_user")
    private SocialUser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
