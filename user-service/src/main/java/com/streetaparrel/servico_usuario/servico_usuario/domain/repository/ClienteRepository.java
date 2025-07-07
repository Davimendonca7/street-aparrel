package com.streetaparrel.servico_usuario.servico_usuario.domain.repository;

import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(@NotNull String cpf);
}
