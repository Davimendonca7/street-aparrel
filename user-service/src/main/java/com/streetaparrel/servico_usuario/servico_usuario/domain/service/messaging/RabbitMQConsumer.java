package com.streetaparrel.servico_usuario.servico_usuario.domain.service.messaging;


import com.streetaparrel.servico_usuario.servico_usuario.domain.dto.cliente.DadosCadastroCliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.entity.Cliente;
import com.streetaparrel.servico_usuario.servico_usuario.domain.repository.ClienteRepository;
import com.streetaparrel.servico_usuario.servico_usuario.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    @RabbitListener(queues = "user-queue")
    public void receiveMessage(DadosCadastroCliente clienteDto){
        System.out.println("Mensagem recebida: " +  clienteDto);

        clienteService.cadastrarCliente(clienteDto);

    }
}
