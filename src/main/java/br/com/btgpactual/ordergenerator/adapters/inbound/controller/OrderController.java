package br.com.btgpactual.ordergenerator.adapters.inbound.controller;

import br.com.btgpactual.ordergenerator.adapters.inbound.request.OrderRequest;
import br.com.btgpactual.ordergenerator.app.services.OrderService;
import br.com.btgpactual.ordergenerator.app.usecase.OrderUseCase;
import br.com.btgpactual.ordergenerator.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderUseCase orderUseCase;

    @Autowired
    public OrderController(OrderService orderService, OrderUseCase orderUseCase) {
        this.orderService = orderService;
        this.orderUseCase = orderUseCase;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Object> createOrder(@Validated @RequestBody OrderRequest orderRequest) {
        Order order = orderService.toDomain(orderRequest);
        orderUseCase.processOrder(order);
        return ResponseEntity.accepted().build();
    }
}
