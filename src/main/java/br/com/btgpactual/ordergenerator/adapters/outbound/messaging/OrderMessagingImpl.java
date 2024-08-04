package br.com.btgpactual.ordergenerator.adapters.outbound.messaging;

import br.com.btgpactual.ordergenerator.adapters.outbound.messaging.response.OrderResponse;
import br.com.btgpactual.ordergenerator.domain.model.Order;
import br.com.btgpactual.ordergenerator.ports.out.OrderMessaging;
import com.google.gson.Gson;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderMessagingImpl implements OrderMessaging {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final Gson gson = new Gson();

    @Autowired
    public OrderMessagingImpl(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public void sendOrder(Order order) {
        OrderResponse orderResponse = toResponse(order);
        String payload = gson.toJson(orderResponse);
        rabbitTemplate.convertAndSend(queue.getName(), payload);
    }

    private OrderResponse toResponse(Order order) {
        List<OrderResponse.ItensResponse> responseItens = order.itens().stream()
                .map(iten -> new OrderResponse.ItensResponse(iten.product(), iten.quantity(), iten.price()))
                .collect(Collectors.toList());

        return new OrderResponse(order.orderId(), order.clientId(), responseItens);
    }
}
