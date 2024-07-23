package br.com.btgpactual.ordergenerator.adapters.inbound.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "myQueue")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
