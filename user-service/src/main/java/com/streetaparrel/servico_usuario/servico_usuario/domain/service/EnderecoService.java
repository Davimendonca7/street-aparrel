package com.streetaparrel.servico_usuario.servico_usuario.domain.service;

import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.endereco.EnderecoReqDto;
import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Endereco;
import com.streetaparrel.servico_usuario.servico_usuario.domain.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco salvarEndereco(EnderecoReqDto enderecoReqDto){

        Endereco endereco = Endereco.builder()
                .cep(enderecoReqDto.cep())
                .cidade(enderecoReqDto.cidade())
                .estado(enderecoReqDto.estado())
                .rua(enderecoReqDto.rua())
                .build();

        enderecoRepository.save(endereco);

        return endereco;

    }
}
