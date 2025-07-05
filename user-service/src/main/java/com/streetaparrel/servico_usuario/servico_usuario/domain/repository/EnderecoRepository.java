package com.streetaparrel.servico_usuario.servico_usuario.domain.repository;

import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    boolean existsByCepAndRuaAndNumero(
            @NotBlank String cep, @NotBlank String rua, @NotNull String numero);
}
