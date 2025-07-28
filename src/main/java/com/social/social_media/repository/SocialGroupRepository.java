package com.social.social_media.repository;

import com.social.social_media.model.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialGroupRepository extends JpaRepository<SocialGroup,Long> {

}
