package com.streetaparrel.servico_produto.domain.estoque;

import com.streetaparrel.servico_produto.domain.estoque.dto.DadosAtualizarEstoque;
import com.streetaparrel.servico_produto.domain.estoque.dto.DadosCadastroEstoque;
import com.streetaparrel.servico_produto.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "estoque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "data_atualizacao", updatable = false)
    private LocalDateTime dataAtualizacao;

    public Estoque(DadosCadastroEstoque dados) {
        this.quantidade = dados.quantidade();
    }

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate() {
        this.dataAtualizacao = LocalDateTime.now();  // Atualiza a data de última alteração
    }

    public void atualizarInformacoes(DadosAtualizarEstoque dados) {
        this.quantidade = dados.quantidade();
    }
}

