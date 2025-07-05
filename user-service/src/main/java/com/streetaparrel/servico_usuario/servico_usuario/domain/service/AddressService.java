package com.streetaparrel.servico_usuario.servico_usuario.domain.service;

import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco.AddressReqDto;
import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Endereco;
import com.streetaparrel.servico_usuario.servico_usuario.domain.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco salvarEndereco(AddressReqDto addressReqDto){

        if(enderecoRepository.existsByCepAndRuaAndNumero(
                addressReqDto.cep(),
                addressReqDto.rua(),
                addressReqDto.numero()
                )){
            throw  new RuntimeException("Endereço já cadastrado");
        }

        Endereco endereco = Endereco.builder()
                .cep(addressReqDto.cep())
                .cidade(addressReqDto.cidade())
                .estado(addressReqDto.estado())
                .rua(addressReqDto.rua())
                .build();

        enderecoRepository.save(endereco);

        return endereco;

    }
}
