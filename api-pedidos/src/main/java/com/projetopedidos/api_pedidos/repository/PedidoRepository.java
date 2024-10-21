package com.projetopedidos.api_pedidos.repository;

import com.projetopedidos.api_pedidos.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Page<Pedido> findByIdProduto(Long idProduto, Pageable pagination);
}
