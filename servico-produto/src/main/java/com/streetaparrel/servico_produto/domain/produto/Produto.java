package com.streetaparrel.servico_produto.domain.produto;

import com.streetaparrel.servico_produto.domain.categoria.Categoria;
import com.streetaparrel.servico_produto.domain.produto.dto.DadosAtualizarProduto;
import com.streetaparrel.servico_produto.domain.produto.dto.DadosCadastroProduto;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity(name = "Produto")
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")  // Alterado para 'nome' para ser consistente com o banco
    private String name;

    private String descricao;

    private Double preco;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @ManyToOne  // Definindo a relação com Categoria
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")  // Chave estrangeira
    private Categoria categoria;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Produto(DadosCadastroProduto dados) {
        this.name = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.imagemUrl = dados.imagemUrl();
    }

    public void atualizarInformacoes(DadosAtualizarProduto dados, Categoria categoria) {
        if (dados.nome() != null){ this.name = dados.nome();}
        if (dados.descricao() != null){this.descricao = dados.descricao();}
        if (dados.preco() != null){this.preco = dados.preco();}
        if (dados.imagemUrl() != null){this.imagemUrl = dados.imagemUrl();}
        if(categoria != null){ this.categoria = categoria;}
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
