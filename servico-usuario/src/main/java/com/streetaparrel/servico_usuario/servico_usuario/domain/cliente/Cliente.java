package com.streetaparrel.servico_usuario.servico_usuario.domain.cliente;

import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto.DadosCadastroCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Cliente")
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Cliente(DadosCadastroCliente dadosCadastro) {
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
