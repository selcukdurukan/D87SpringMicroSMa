package com.ba.boost.rabbitmq.producer;

import com.ba.boost.rabbitmq.model.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {

    /**
     * RabbitMQ üzerinden bir mesaj göndermek için özel bir template'e ihtiyacımız vardır.
     */
    private final RabbitTemplate rabbitTemplate;

    /**
     * Eğer bir mesaj gödneren method yazacaksınız mutlaka void olmalıdır.
     */
    public void convertAndSendMessageCreateUser(CreateUser createUser){
        rabbitTemplate.convertAndSend("exchange-auth", "key-auth", createUser);
    }


}
