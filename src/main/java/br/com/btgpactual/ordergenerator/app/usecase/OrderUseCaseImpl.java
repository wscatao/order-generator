package br.com.btgpactual.ordergenerator.app.usecase;

import br.com.btgpactual.ordergenerator.domain.model.Order;
import br.com.btgpactual.ordergenerator.ports.out.OrderMessaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderUseCaseImpl implements OrderUseCase {

    private final OrderMessaging orderMessaging;

    @Autowired
    public OrderUseCaseImpl(OrderMessaging orderMessaging) {
        this.orderMessaging = orderMessaging;
    }

    @Override
    public void processOrder(Order order) {
        orderMessaging.sendOrder(order);
    }
}
