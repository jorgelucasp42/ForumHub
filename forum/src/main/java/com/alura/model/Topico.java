package com.alura.forum.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Data
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @NotBlank
    private String estado;

    @NotBlank
    private String autor;

    @NotBlank
    private String curso;
}
