package com.hyrule.zelda.controller;

import com.hyrule.zelda.entity.Personagem;
import com.hyrule.zelda.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemRepository personagemRepository;

    // GET - Listar todos
    @GetMapping
    public List<Personagem> listarTodos() {
        return personagemRepository.findAll();
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Personagem> buscarPorId(@PathVariable Long id) {
        return personagemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Salvar novo personagem
    @PostMapping
    public Personagem criar(@RequestBody Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    // PUT - Atualizar personagem existente
    @PutMapping("/{id}")
    public ResponseEntity<Personagem> atualizar(@PathVariable Long id, @RequestBody Personagem dadosAtualizados) {
        return personagemRepository.findById(id)
                .map(personagem -> {
                    personagem.setNome(dadosAtualizados.getNome());
                    personagem.setRaca(dadosAtualizados.getRaca());
                    personagem.setPapel(dadosAtualizados.getPapel());
                    personagem.setCoracoes(dadosAtualizados.getCoracoes());
                    Personagem atualizado = personagemRepository.save(personagem);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Remover personagem por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (personagemRepository.existsById(id)) {
            personagemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
