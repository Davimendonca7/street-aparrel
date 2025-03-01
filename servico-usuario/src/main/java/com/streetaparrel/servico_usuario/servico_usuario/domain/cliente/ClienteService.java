package com.streetaparrel.servico_usuario.servico_usuario.domain.cliente;

import com.streetaparrel.servico_usuario.servico_usuario.domain.cliente.dto.DadosCadastroCliente;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;


    @Transactional
    public Cliente cadastrarCliente(DadosCadastroCliente dadosCadastro) {
        Cliente cliente = new Cliente(dadosCadastro);


        clienteRepository.save(cliente);

        return cliente;
    }
}


