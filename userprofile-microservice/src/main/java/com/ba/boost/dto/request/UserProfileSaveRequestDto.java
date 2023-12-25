package com.ba.boost.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileSaveRequestDto {

    private String id;
    private String userProfileId; //UserProfileService'in entity id'si
    private Long authId;  //AuthService'in entity id'si
    private String username;
    private String profileImage;
}
