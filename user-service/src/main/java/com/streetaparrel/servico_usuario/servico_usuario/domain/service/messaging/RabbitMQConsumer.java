package com.streetaparrel.servico_usuario.servico_usuario.domain.service.messaging;


import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.ClientReqDto;
import com.streetaparrel.servico_usuario.servico_usuario.domain.repository.ClienteRepository;
import com.streetaparrel.servico_usuario.servico_usuario.domain.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final ClienteRepository clienteRepository;
    private final ClientService clienteService;

    @RabbitListener(queues = "user-queue")
    public void receiveMessage(ClientReqDto clienteDto){
        log.info("Mensagem recebida: {}", clienteDto);
        System.out.println("Mensagem recebida: " +  clienteDto);

        clienteService.cadastrarCliente(clienteDto);

    }
}
