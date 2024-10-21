package com.projetopedidos.api_pedidos.service;

import com.projetopedidos.api_pedidos.dto.PedidoDto;
import com.projetopedidos.api_pedidos.enums.PedidoStatus;
import com.projetopedidos.api_pedidos.model.Pedido;
import com.projetopedidos.api_pedidos.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public Page<PedidoDto> findAll(Pageable pagination){
        return pedidoRepository.findAll(pagination).map(pedido -> new PedidoDto(pedido));
    }

    public PedidoDto findById(Long id){
        return new PedidoDto(pedidoRepository.getReferenceById(id));
    }

    public Page<PedidoDto> findByIdProduto(Long id, Pageable pagination){
        return pedidoRepository.findByIdProduto(id, pagination).map(pedido -> new PedidoDto(pedido));
    }

    @Transactional
    public PedidoDto save(PedidoDto pedidoDto){
        Pedido pedido = Pedido.fromDto(pedidoDto);
        return new PedidoDto(pedidoRepository.save(pedido));
    }

    @Transactional
    public PedidoDto update(Long id, PedidoDto pedidoDto){
        Pedido pedido = Pedido.fromDto(pedidoDto);
        pedido.setId(id);
        return new PedidoDto(pedidoRepository.save(pedido));
    }

    @Transactional
    public PedidoDto updateStatus(Long id, String status){
        Pedido pedido = pedidoRepository.getReferenceById(id);
        pedido.setPedidoStatus(PedidoStatus.valueOf(status));
        return new PedidoDto(pedido);
    }

    @Transactional
    public void delete(Long id){
        pedidoRepository.deleteById(id);
    }
}
