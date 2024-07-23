package br.com.btgpactual.ordergenerator.adapters.inbound.request;

import br.com.btgpactual.ordergenerator.config.common.annotation.ValidUUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {

    @NotBlank
    @ValidUUID
    private String orderId;

    @NotBlank
    @ValidUUID
    private String clientId;

    @NotEmpty
    private List<ItensRequest> itens;

    @Getter
    @Setter
    public static class ItensRequest {

        @NotBlank
        private String product;

        @NotNull
        private int quantity;

        @NotNull
        private double price;
    }
}
