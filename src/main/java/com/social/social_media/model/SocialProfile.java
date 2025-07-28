package com.social.social_media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    //foreign key pointing to the id in the social_user table
    //but this class is the owner of the relationship
    @OneToOne
    @JoinColumn(name = "social_user")
    @JsonIgnore
    private SocialUser user;

    private String description;

    public void setSocialUser(SocialUser socialUser){
        this.user = socialUser;
        if(user.getSocialProfile() != this){
            user.setSocialProfile(this);
        }
    }

}
