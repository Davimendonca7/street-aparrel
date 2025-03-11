package com.streetaparrel.servico_usuario.servico_usuario.domain.endereco;

import com.streetaparrel.servico_usuario.servico_usuario.domain.endereco.dto.EnderecoReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(EnderecoReqDto enderecoReqDto){

        Endereco endereco = Endereco.builder()
                .cep(enderecoReqDto.cep())
                .cidade(enderecoReqDto.cidade())
                .estado(enderecoReqDto.estado())
                .rua(enderecoReqDto.rua())
                .build();

        return enderecoRepository.save(endereco);


    }
}
