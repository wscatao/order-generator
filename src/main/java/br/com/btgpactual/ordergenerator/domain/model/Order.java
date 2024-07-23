package br.com.btgpactual.ordergenerator.domain.model;

import java.util.List;

public record Order(String orderId, String clientId, List<Itens> itens) {
    public record Itens(String product, int quantity, double price) {}
}
