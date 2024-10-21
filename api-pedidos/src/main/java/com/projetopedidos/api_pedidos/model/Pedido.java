package com.projetopedidos.api_pedidos.model;

import com.projetopedidos.api_pedidos.dto.PedidoDto;
import com.projetopedidos.api_pedidos.enums.PedidoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPedido;
    private String endereco;

    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;

    private Long idProduto;

    public static Pedido fromDto(PedidoDto pedidoDto){
        return new Pedido(null, pedidoDto.dataPedido(), pedidoDto.endereco(), pedidoDto.pedidoStatus(), pedidoDto.idProduto());
    }
}
