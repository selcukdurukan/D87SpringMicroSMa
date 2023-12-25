package com.ba.boost.utility;

import com.ba.boost.exception.ErrorType;
import com.ba.boost.exception.ProductMicroserviceException;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {

    public String createToken(Long userId) {
        String token = "Brr:"+userId;
        return token;
    }

    public Long decodeToken(String token) {
        try {
            if (!token.split(":")[0].equals("Brr"))
                throw new ProductMicroserviceException(ErrorType.INVALID_TOKEN);
            String userId = token.split(":")[1]; //Brr:16 -> [Brr,16]
            return Long.parseLong(userId);
        } catch (Exception e) {
            throw new ProductMicroserviceException(ErrorType.INVALID_TOKEN);
        }
    }

}
