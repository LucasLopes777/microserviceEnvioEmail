package com.ledok.ms.user.producers;

import com.ledok.ms.user.dtos.EmailDto;
import com.ledok.ms.user.models.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {

    private  final RabbitTemplate rabbitTemplate;

    @Value( value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {

        EmailDto emailDto = EmailDto.builder()
                .userId(userModel.getUseId())
                .emailTo(userModel.getEmail())
                .subject("Cadastro realizado com sucesso!")
                .text(userModel.getName() + ", seja bem vindo!" +
                        "\nAgradecemos o seu cadastro.")
                .build();

        rabbitTemplate.convertAndSend("",routingKey, emailDto);

    }

}
