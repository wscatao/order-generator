package br.com.btgpactual.ordergenerator.adapters.inbound.request;

import br.com.btgpactual.ordergenerator.config.common.annotation.ValidUUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderRequest(
        @NotBlank
        @ValidUUID
        String orderId,
        @NotBlank
        @ValidUUID
        String clientId,
        @NotEmpty
        List<ItensRequest> itens
) {
    public record ItensRequest(
            @NotBlank
            String product,
            @NotNull
            int quantity,
            @NotNull
            double price
    ) {};
};
