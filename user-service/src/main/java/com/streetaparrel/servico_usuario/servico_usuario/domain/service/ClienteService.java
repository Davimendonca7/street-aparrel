package com.streetaparrel.servico_usuario.servico_usuario.domain.service;

import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.DadosCadastroCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Endereco;
import com.streetaparrel.servico_usuario.servico_usuario.domain.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoService enderecoService;


    @Transactional
    public Cliente cadastrarCliente(DadosCadastroCliente dadosCadastro) {
       Endereco endereco = enderecoService.salvarEndereco(dadosCadastro.endereco());

        Cliente cliente = new Cliente(dadosCadastro);
        cliente.setEndereco(endereco);

        clienteRepository.save(cliente);

        return cliente;
    }
}


