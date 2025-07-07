package com.streetaparrel.servico_usuario.servico_usuario.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "endereco")
@Entity(name = "Endereco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String numero;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", unique = true)
    private Cliente cliente;

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
