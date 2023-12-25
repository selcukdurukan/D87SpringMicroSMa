package com.ba.boost.utility;

import com.ba.boost.dto.request.UserProfileSaveRequestDto;
import com.ba.boost.manager.IUserProfileElasticService;
import com.ba.boost.repository.IUserProfileRepository;
import com.ba.boost.repository.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MyData {

    private final IUserProfileRepository repository;

    private final IUserProfileElasticService manager;


//    @PostConstruct
    public void init() {
        repository.findAll().forEach(u->{
            manager.save(UserProfileSaveRequestDto.builder()
                    .username(u.getUsername())
                    .authId(u.getAuthId())
                    .profileImage(u.getProfileImage())
                    .userProfileId(u.getId())
                    .build());
        });
    }

}
