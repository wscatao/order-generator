package br.com.btgpactual.ordergenerator.adapters.outbound.messaging.response;

import java.util.List;

public record OrderResponse(String orderId, String clientId, List<OrderResponse.ItensResponse> itens) {
    public record ItensResponse(String product, int quantity, double price) {}
}
