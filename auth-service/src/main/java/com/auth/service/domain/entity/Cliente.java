package com.auth.service.domain.entity;

import com.auth.service.domain.DTOs.EnderecoReqDto;
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
    private EnderecoReqDto enderecoReqDto;
}
