/**
 * Postgreden --> Mongoya
 * Long -> String çünkü mongoda long kullanılmaz..
 */


/*
package com.ba.boost.service;

import com.ba.boost.exception.ErrorType;
import com.ba.boost.exception.UserProfileMicroserviceException;
import com.ba.boost.repository.IUserProfileRepository;
import com.ba.boost.repository.entity.UserProfile;
import com.ba.boost.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceOld extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository repository;

    public UserProfileServiceOld(IUserProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }


    public List<UserProfile> findAll(Long userId) {
        Optional<UserProfile> userProfile = repository.findOptionalByAuthId(userId);
        if (userProfile.isEmpty())
            throw new UserProfileMicroserviceException(ErrorType.UNAUTHORIZED_REQUEST);
        return findAll();
    }

}
*/
