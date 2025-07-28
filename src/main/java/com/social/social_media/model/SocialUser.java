package com.social.social_media.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    //foreign key pointing to the id in the social_profile table
    //owner of the relationship
    @OneToOne(mappedBy = "user")
    private SocialProfile socialProfile;

    //owner of the relationship
    @OneToMany(mappedBy = "socialUser")
    private List<Post> posts = new ArrayList<>();

    //using set because we want a unique set of users i.e a user can join one unique group
    @ManyToMany
    private Set<Group> groups = new HashSet<>();
}
