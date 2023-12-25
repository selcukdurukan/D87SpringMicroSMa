package com.ba.boost.service;

import com.ba.boost.repository.IUserProfileRepository;
import com.ba.boost.repository.entity.UserProfile;
import com.ba.boost.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile, String> {

    private IUserProfileRepository repository;


    public UserProfileService(IUserProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public UserProfile findByUsername(String username){
        Optional<UserProfile> result = repository.findOptionalByUsername(username);
        if (result.isEmpty())
            return UserProfile.builder().build(); //UserProfile.builder().build() = null
        return result.get();
    }

}
