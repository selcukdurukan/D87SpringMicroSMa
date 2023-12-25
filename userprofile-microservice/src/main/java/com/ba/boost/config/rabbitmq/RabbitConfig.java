package com.ba.boost.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //
public class RabbitConfig {

    /**
     * Oluşturacağımız kuyruk sistemi için temel olan parametrelerin isimlendirmesini yapıyoruz
     */
    private String exchangeAuth = "exchange-auth";
    private String keyAuth = "key-auth";
    private String queueAuth = "queue-auth-create-user";

    /**
     * Oluşturlacak kuyruk için gerekli olan 2 nesnemizin oluşması için methodları yazıyoruz.
     * 1 - Exchange nesenesi -> Direct, Fanout, Topic
     * 2 - Queue Nesnesi -> kuyruk
     * Dikkat!!! Yazdığınız methodlardan String nesne oluşturması için @Bean anotastonunu eklemelisiniz.
     *
     * @return
     */

    @Bean
    DirectExchange exchangeAuth() {
        return new DirectExchange(exchangeAuth);
    }

    @Bean
    Queue queueCreateUser() {
        return new Queue(queueAuth);
    }

    /**
     * Oluşturduğunuz iki nesneyi(Exchange, Queue) birbirine bellir bir key üzerinden bağlamak için binding nesnesi
     * yaratıyoruz. Bu işlem rabbitMq üzerinde bir kuyruk oluşturacaktır.
     */
    @Bean
    public Binding bindingCreateUser (final Queue queueCreateUser, final DirectExchange exchangeAuth){
        return BindingBuilder.bind(queueCreateUser).to(exchangeAuth).with(keyAuth);
    }

}
