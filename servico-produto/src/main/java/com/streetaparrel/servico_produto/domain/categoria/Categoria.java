package com.streetaparrel.servico_produto.domain.categoria;

import com.streetaparrel.servico_produto.domain.categoria.dto.DadosAtualizarCategoria;
import com.streetaparrel.servico_produto.domain.categoria.dto.DadosCadastroCategoria;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    public Categoria(DadosCadastroCategoria dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
    }

    public void atualizarInformacoes(DadosAtualizarCategoria dados) {
        if(dados.nome() != null){ this.nome = dados.nome();}
        if(dados.descricao() != null){ this.descricao = dados.descricao();}
    }
}
