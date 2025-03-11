package com.streetaparrel.servico_usuario.servico_usuario.domain.cliente;

import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto.DadosCadastroCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.Endereco;
import com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.EnderecoService;
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


