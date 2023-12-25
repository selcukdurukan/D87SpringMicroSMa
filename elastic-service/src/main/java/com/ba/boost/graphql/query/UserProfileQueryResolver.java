package com.ba.boost.graphql.query;

import com.ba.boost.repository.entity.UserProfile;
import com.ba.boost.service.UserProfileService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserProfileQueryResolver implements GraphQLQueryResolver {

    private final UserProfileService userProfileService;


    public Iterable<UserProfile> findAll(){
        return userProfileService.findAll();
    }

    public UserProfile findByUsername(String username){
        return userProfileService.findByUsername(username);
    }

}
