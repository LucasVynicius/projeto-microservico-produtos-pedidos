package com.projetopedidos.api_pedidos.controller;

import com.projetopedidos.api_pedidos.dto.PedidoDto;
import com.projetopedidos.api_pedidos.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/pedidos",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<Page<PedidoDto>> findAll(@PageableDefault(size = 5) Pageable pagination){
        return ResponseEntity.ok(pedidoService.findAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Page<PedidoDto>> findByIdProduto(@PathVariable Long idProduto, @PageableDefault(size = 5) Pageable pagination){
        return ResponseEntity.ok(pedidoService.findByIdProduto(idProduto, pagination));
    }

    @PostMapping
    public ResponseEntity<PedidoDto> save(@RequestBody PedidoDto pedidoDto){
        return ResponseEntity.status(201).body(pedidoService.save(pedidoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> update(@PathVariable Long id, @RequestBody @Validated PedidoDto pedidoDto){
        return ResponseEntity.ok(pedidoService.save(pedidoDto));
    }

    @PatchMapping("/{id}/updateStatus")
    public ResponseEntity<PedidoDto> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body){
        String status = body.get("status");
        return ResponseEntity.ok(pedidoService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
