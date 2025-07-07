package com.streetaparrel.servico_produto.domain.estoque;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Estoque findByProdutoId(Long Id);
}
