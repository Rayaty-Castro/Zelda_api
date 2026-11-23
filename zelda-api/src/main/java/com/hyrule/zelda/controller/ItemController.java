package com.hyrule.zelda.controller;

import com.hyrule.zelda.entity.Item;
import com.hyrule.zelda.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    // GET - Listar todos
    @GetMapping
    public List<Item> listarTodos() {
        return itemRepository.findAll();
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        return itemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Salvar novo item
    @PostMapping
    public Item criar(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    // PUT - Atualizar item existente
    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizar(@PathVariable Long id, @RequestBody Item dadosAtualizados) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setNome(dadosAtualizados.getNome());
                    item.setTipo(dadosAtualizados.getTipo());
                    item.setPoder(dadosAtualizados.getPoder());
                    item.setRaridade(dadosAtualizados.getRaridade());
                    Item atualizado = itemRepository.save(item);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Remover item por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
