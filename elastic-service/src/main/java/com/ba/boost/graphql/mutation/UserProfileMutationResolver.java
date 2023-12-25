package com.ba.boost.graphql.mutation;

import com.ba.boost.graphql.model.UserProfileInput;
import com.ba.boost.repository.entity.UserProfile;
import com.ba.boost.service.UserProfileService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileMutationResolver implements GraphQLMutationResolver {

    private final UserProfileService userProfileService;

    public Boolean createUserProfile(UserProfileInput user) {
        userProfileService.save(
                UserProfile.builder()
                        .authId(user.getAuthId())
                        .username(user.getUsername())
                        .profileImage(user.getProfileImage())
                        .build()
        );
        return true;
    }

}
