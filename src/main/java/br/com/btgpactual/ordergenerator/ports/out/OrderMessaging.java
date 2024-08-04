package br.com.btgpactual.ordergenerator.ports.out;

import br.com.btgpactual.ordergenerator.domain.model.Order;

public interface OrderMessaging {

    void sendOrder(Order order);
}
