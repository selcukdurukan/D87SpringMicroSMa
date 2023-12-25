package com.ba.boost.rabbitmq.consumer;

import com.ba.boost.rabbitmq.model.CreateUser;
import com.ba.boost.repository.entity.UserProfile;
import com.ba.boost.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserConsumer {

    private final UserProfileService userProfileService;

    /**
     * Dinlemek istediğimiz kuyruğu handle etmemiz gerekiyor(Listener kullanılacak).
     * bu sayede, kuyrukta base64 formatında olan metin okunarak deserialize edilir ve CreateUser nesnesin dönüşür.
     * @param createUser
     */

    @RabbitListener(queues = "queue-auth-create-user")
    public void createUserFromHandleQueue(CreateUser createUser){
        userProfileService.save(UserProfile.builder()
                .email(createUser.getEmail())
                .username(createUser.getUsername())
                .authId(createUser.getAuthId())
                .build());
    }
}
