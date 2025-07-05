package com.streetaparrel.servico_usuario.servico_usuario.domain.service;

import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.ClientReqDto;
import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Endereco;
import com.streetaparrel.servico_usuario.servico_usuario.domain.exception.UserNotFound;
import com.streetaparrel.servico_usuario.servico_usuario.domain.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClienteRepository clienteRepository;
    private final AddressService addressService;


    @Transactional
    public Cliente cadastrarCliente(ClientReqDto dadosCadastro) {
       if(clienteRepository.existsByCpf(dadosCadastro.cpf())){
           throw new RuntimeException("Cliente já cadastrado");
       }

       Cliente cliente = new Cliente(dadosCadastro);
       Endereco endereco = addressService.salvarEndereco(dadosCadastro.endereco());

       cliente.setEndereco(endereco);

       clienteRepository.save(cliente);

       return cliente;
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new UserNotFound("Usuario não encontrado"));
    }
}


