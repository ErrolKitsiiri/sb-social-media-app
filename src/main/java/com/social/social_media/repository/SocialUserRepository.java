package com.social.social_media.repository;

import com.social.social_media.model.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialUserRepository extends JpaRepository<SocialUser,Long> {

}
