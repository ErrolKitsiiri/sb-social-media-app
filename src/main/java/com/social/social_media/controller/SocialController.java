package com.social.social_media.controller;

import com.social.social_media.model.SocialUser;
import com.social.social_media.service.SocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    private final SocialService socialService;

    public SocialController(SocialService socialService) {
        this.socialService = socialService;
    }

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers() {
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {
        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/social/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        socialService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

}
