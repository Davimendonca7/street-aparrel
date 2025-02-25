package com.streetaparrel.servico_usuario.servico_usuario.domain.cliente;

import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto.DadosCadastroCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.Usuario;
import com.streetaparrel.servico_usuario.servico_usuario.domain.usuario.dto.DadosCadastroUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;


    @Transactional
    public Cliente cadastrarCliente(DadosCadastroCliente dadosCadastro) {
        Usuario usuario = new Usuario(dadosCadastro);
        Cliente cliente = new Cliente(dadosCadastro);

        usuario.setCliente(cliente);
        cliente.setUsuario(usuario);

        clienteRepository.save(cliente);

        return cliente;
    }
}


