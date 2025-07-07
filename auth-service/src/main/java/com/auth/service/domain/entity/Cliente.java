package com.auth.service.domain.entity;

import com.auth.service.domain.DTOs.endereco.EnderecoReqDto;
import com.auth.service.domain.DTOs.user.UserReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private UUID id;
    private String nome;
    private String cpf;
    private String telefone;
    private EnderecoReqDto endereco;

    public Cliente(UserReqDto userReqDto){
        this.nome = userReqDto.nome();
        this.cpf = userReqDto.cpf();
        this.telefone = userReqDto.telefone();
        this.endereco = userReqDto.endereco();
    }
}
