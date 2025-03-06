package com.streetaparrel.servico_usuario.servico_usuario.domain.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "endereco")
@Entity(name = "Endereco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String cidade;
    private String estado;
    private String cep;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        this.dataCriacao = now;
        this.dataAtualizacao = now;
    }

    @PreUpdate
    public void PreUpdate(){
        this.dataAtualizacao = LocalDateTime.now();
    }

}
