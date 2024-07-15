package com.alura.forum.controller;

import com.alura.forum.model.Topico;
import com.alura.forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @GetMapping
    public List<Topico> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Topico create(@RequestBody @Valid Topico topico) {
        return service.create(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> update(@PathVariable Long id, @RequestBody @Valid Topico topico) {
        try {
            return ResponseEntity.ok(service.update(id, topico));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
