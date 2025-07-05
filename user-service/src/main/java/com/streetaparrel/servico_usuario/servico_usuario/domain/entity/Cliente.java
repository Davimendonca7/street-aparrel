package com.streetaparrel.servico_usuario.servico_usuario.domain.entity;

import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.ClientReqDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Cliente")
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @Column(columnDefinition = "CHAR(36)")
    private String id;
    private String nome;
    private String cpf;
    private String telefone;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Endereco endereco;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Cliente(ClientReqDto dadosCadastro) {
        this.id = dadosCadastro.id();
        this.nome = dadosCadastro.nome();
        this.cpf = dadosCadastro.cpf();
        this.telefone = dadosCadastro.telefone();
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.dataCriacao = now;
        this.dataAtualizacao = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
