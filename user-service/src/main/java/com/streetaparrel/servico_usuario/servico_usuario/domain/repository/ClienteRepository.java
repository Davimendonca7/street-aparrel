package com.streetaparrel.servico_usuario.servico_usuario.domain.repository;

import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
