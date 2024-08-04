package br.com.btgpactual.ordergenerator.app.usecase;

import br.com.btgpactual.ordergenerator.domain.model.Order;

public interface OrderUseCase {
    void processOrder(Order order);
}
