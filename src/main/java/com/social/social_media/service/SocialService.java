package com.social.social_media.service;

import com.social.social_media.model.SocialUser;
import com.social.social_media.repository.SocialUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    private final SocialUserRepository socialUserRepository;

    public SocialService(SocialUserRepository socialUserRepository) {
        this.socialUserRepository = socialUserRepository;
    }

    public List<SocialUser> getAllUsers(){
        return socialUserRepository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser){
        return socialUserRepository.save(socialUser);
    }

    public SocialUser deleteUser(Long id) {
        SocialUser socialUser = socialUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        socialUserRepository.delete(socialUser);
        return socialUser;
    }
}
