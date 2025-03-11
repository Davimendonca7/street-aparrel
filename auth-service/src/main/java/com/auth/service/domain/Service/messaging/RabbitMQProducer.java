package com.auth.service.domain.Service.messaging;

import com.auth.service.config.rabbitmq.RabbitMQConfig;
import com.auth.service.domain.entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(Cliente cliente){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, cliente);
        System.out.println("Mensagem enviada para a fila: " + cliente);
    }
}
