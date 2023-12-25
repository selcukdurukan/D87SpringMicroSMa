package com.ba.boost.manager;

import com.ba.boost.dto.request.UserProfileSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * isimlendirme benzersiz uniq olmalıdır.!!!
 */
@FeignClient(name = "user-profile-elasticsearch", url = "${myapplication.feign-client.elasticsearch}", decode404 = true)
public interface IUserProfileElasticService {

    @PostMapping("/save")
    ResponseEntity<Void> save(@RequestBody UserProfileSaveRequestDto dto);
}
