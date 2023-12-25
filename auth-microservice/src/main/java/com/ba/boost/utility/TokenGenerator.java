package com.ba.boost.utility;

import com.ba.boost.exception.AuthMicroserviceException;
import com.ba.boost.exception.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {

    public String createToken(Long userId) {
        String token = "Brr:"+userId;
        return token;
    }

    public Long decodeToken(String token) {
        try {
            String userId = token.split(":")[1];
            return Long.parseLong(userId);
        } catch (Exception e) {
            throw new AuthMicroserviceException(ErrorType.INTERNAL_ERROR);
        }
    }

}
