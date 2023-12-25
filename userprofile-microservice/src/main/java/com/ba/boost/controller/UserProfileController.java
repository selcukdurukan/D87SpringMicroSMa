package com.ba.boost.controller;

import com.ba.boost.dto.request.BaseRequestDto;
import com.ba.boost.dto.request.CreateProfileRequestDto;
import com.ba.boost.repository.entity.UserProfile;
import com.ba.boost.service.UserProfileService;
import com.ba.boost.utility.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.ba.boost.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {

    private final UserProfileService userProfileService;

/*    private final TokenGenerator tokenGenerator;

    @PostMapping(GETALL)
    public ResponseEntity<List<UserProfile>> userProfileList(@RequestBody @Valid BaseRequestDto dto) {
        Long authId = tokenGenerator.decodeToken(dto.getToken());
        return ResponseEntity.ok(userProfileService.findAll(authId));
    }*/

//    @PostMapping(GETALL)
//    public ResponseEntity<List<UserProfile>> userProfileList(@RequestBody @Valid BaseRequestDto dto) {
//        return ResponseEntity.ok(userProfileService.findAll(dto));
//    }

    @PostMapping(GETALL)
    @CrossOrigin("*")
    public ResponseEntity<Page<UserProfile>> userProfileList(@RequestBody @Valid BaseRequestDto dto) {
        return ResponseEntity.ok(userProfileService.findAll(dto));
    }


    /**
     * DİKKAT!!!
     *
     * MUTLAKA @RequestBody and @Valid eklentilerini yapınız.
     * @param dto
     * @return
     */
    @PostMapping(CREATEPROFILE)
    public ResponseEntity<Boolean> createProfile(@RequestBody @Valid CreateProfileRequestDto dto){
        userProfileService.save(
                UserProfile.builder()
                        .authId(dto.getAuthId())
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .build()
        );
        return ResponseEntity.ok(true);
    }

//    @GetMapping(GETALL)
//    @CrossOrigin("*")
//    public ResponseEntity<List<UserProfile>> userProfileList() {
//        return ResponseEntity.ok(userProfileService.findAll());
//    }

    @GetMapping(GETALL)
    @CrossOrigin("*")
    public ResponseEntity<List<UserProfile>> userProfileList() {
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping("/getupper")
    public ResponseEntity<String> getUpperCase(String name){
        return ResponseEntity.ok(userProfileService.getUpperCase(name));
    }

    @GetMapping("/clear")
    public ResponseEntity<Void> clearAll(){
        userProfileService.clearCache();
        return ResponseEntity.ok().build();
    }
}
