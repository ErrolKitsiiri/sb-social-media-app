package com.social.social_media.config;

import com.social.social_media.model.Post;
import com.social.social_media.model.SocialGroup;
import com.social.social_media.model.SocialProfile;
import com.social.social_media.model.SocialUser;
import com.social.social_media.repository.PostRepository;
import com.social.social_media.repository.SocialGroupRepository;
import com.social.social_media.repository.SocialProfileRepository;
import com.social.social_media.repository.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final SocialUserRepository socialUserRepository;
    private final SocialGroupRepository socialGroupRepository;
    private final SocialProfileRepository socialProfileRepository;
    private final PostRepository postRepository;

    public DataInitializer(SocialUserRepository socialUserRepository, SocialGroupRepository socialGroupRepository, SocialProfileRepository socialProfileRepository, PostRepository postRepository) {
        this.socialUserRepository = socialUserRepository;
        this.socialGroupRepository = socialGroupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData(){
        return args -> {
            //creating users
            SocialUser socialUser1 = new SocialUser();
            SocialUser socialUser2 = new SocialUser();
            SocialUser socialUser3 = new SocialUser();

            //saving users to the database
            socialUserRepository.save(socialUser1);
            socialUserRepository.save(socialUser2);
            socialUserRepository.save(socialUser3);

            //creating groups
            SocialGroup socialGroup1 = new SocialGroup();
            SocialGroup socialGroup2 = new SocialGroup();

            //adding users to groups
            socialGroup1.getSocialUsers().add(socialUser1);
            socialGroup1.getSocialUsers().add(socialUser2);

            socialGroup2.getSocialUsers().add(socialUser2);
            socialGroup2.getSocialUsers().add(socialUser3);

            //saving groups to the database
            socialGroupRepository.save(socialGroup1);
            socialGroupRepository.save(socialGroup2);

            //associate users with groups
            socialUser1.getGroups().add(socialGroup1);
            socialUser2.getGroups().add(socialGroup1);
            socialUser2.getGroups().add(socialGroup2);
            socialUser3.getGroups().add(socialGroup2);

            //save users back to db to update associations
            socialUserRepository.save(socialUser1);
            socialUserRepository.save(socialUser2);
            socialUserRepository.save(socialUser3);

            //creating posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            //associate the posts with users
            post1.setSocialUser(socialUser1);
            post2.setSocialUser(socialUser2);
            post3.setSocialUser(socialUser3);

            //save posts to the database using the postRepository
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            //creating social profiles
            SocialProfile socialProfile1 = new SocialProfile();
            SocialProfile socialProfile2 = new SocialProfile();
            SocialProfile socialProfile3 = new SocialProfile();

            //associate profiles with users
            socialProfile1.setUser(socialUser1);
            socialProfile2.setUser(socialUser2);
            socialProfile3.setUser(socialUser3);

            //save profiles to the database using the socialProfileRepository
            socialProfileRepository.save(socialProfile1);
            socialProfileRepository.save(socialProfile2);
            socialProfileRepository.save(socialProfile3);

            //Fetch Types
            System.out.println("Fetching social user");
            socialUserRepository.findById(1L);

        };
    }
}
