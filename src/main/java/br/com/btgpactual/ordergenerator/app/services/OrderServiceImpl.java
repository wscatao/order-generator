package br.com.btgpactual.ordergenerator.app.services;

import br.com.btgpactual.ordergenerator.adapters.inbound.request.OrderRequest;
import br.com.btgpactual.ordergenerator.domain.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    public Order toDomain(OrderRequest orderRequest) {
        List<Order.Itens> domainItems = orderRequest.itens().stream()
                .map(itemRequest -> new Order.Itens(itemRequest.product(), itemRequest.quantity(), itemRequest.price()))
                .collect(Collectors.toList());

        return new Order(orderRequest.orderId(), orderRequest.clientId(), domainItems);
    }
}
