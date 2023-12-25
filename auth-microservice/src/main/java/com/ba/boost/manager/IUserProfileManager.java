package com.ba.boost.manager;

import com.ba.boost.dto.request.CreateProfileRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * isimlendirme benzersiz uniq olmalıdır.!!!
 */
@FeignClient(name = "user-profile-manager", url = "${myapplication.user.feign-url}", decode404 = true)
public interface IUserProfileManager {

    @PostMapping("/createprofile")
    ResponseEntity<Boolean> createProfile(@RequestBody @Valid CreateProfileRequestDto dto);
}
