package com.ba.boost.controller;

import com.ba.boost.dto.request.UserProfileSaveRequestDto;
import com.ba.boost.mapper.IUserProfileMapper;
import com.ba.boost.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/userprofile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;


    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody UserProfileSaveRequestDto dto) {
        userProfileService.save(IUserProfileMapper.INSTANCE.fromUserProfileDto(dto));
        return ResponseEntity.ok().build();
    }


}
