package com.alura.forum.service;

import com.alura.forum.model.Topico;
import com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public List<Topico> findAll() {
        return repository.findAll();
    }

    public Optional<Topico> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Topico create(Topico topico) {
        if (repository.existsByTituloAndMensagem(topico.getTitulo(), topico.getMensagem())) {
            throw new IllegalArgumentException("Tópico duplicado");
        }
        return repository.save(topico);
    }

    @Transactional
    public Topico update(Long id, Topico topico) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Tópico não encontrado");
        }
        topico.setId(id);
        return repository.save(topico);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Tópico não encontrado");
        }
        repository.deleteById(id);
    }
}
