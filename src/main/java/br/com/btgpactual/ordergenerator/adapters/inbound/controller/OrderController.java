package br.com.btgpactual.ordergenerator.adapters.inbound.controller;

import br.com.btgpactual.ordergenerator.adapters.inbound.request.OrderRequest;
import br.com.btgpactual.ordergenerator.domain.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/createOrder")
    public ResponseEntity<Object> createOrder(@Validated @RequestBody OrderRequest orderRequest) {

        Order order = toDomain(orderRequest);

        // Return the order ID or relevant response
        return ResponseEntity.ok("Order created successfully with ID: " + orderRequest.getOrderId());
    }

    private Order toDomain(OrderRequest orderRequest) {
        List<Order.Itens> orderItens = convertItens(orderRequest.getItens());
        return new Order(orderRequest.getOrderId(), orderRequest.getClientId(), orderItens);
    }
    private List<Order.Itens> convertItens(List<OrderRequest.ItensRequest> itensRequests) {
        return itensRequests.stream()
                .map(iten -> new Order.Itens(iten.getProduct(), iten.getQuantity(), iten.getPrice()))
                .collect(Collectors.toList());
    }
}

