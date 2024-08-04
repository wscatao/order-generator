package br.com.btgpactual.ordergenerator.app.services;

import br.com.btgpactual.ordergenerator.adapters.inbound.request.OrderRequest;
import br.com.btgpactual.ordergenerator.domain.model.Order;

public interface OrderService {
    Order toDomain(OrderRequest orderRequest);
}
