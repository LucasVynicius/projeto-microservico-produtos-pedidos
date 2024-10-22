package com.projetopedidos.api_pedidos.dto;

import com.projetopedidos.api_pedidos.enums.PedidoStatus;
import com.projetopedidos.api_pedidos.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public record PedidoDto(

        Long id,
        LocalDate dataPedido,
        @NotBlank String endereco,

        @NotBlank PedidoStatus pedidoStatus,
        Long idProduto
) {

    public PedidoDto(Pedido pedido){
        this(pedido.getId(), pedido.getDataPedido(), pedido.getEndereco(),pedido.getPedidoStatus(), pedido.getIdProduto());
    }

}
