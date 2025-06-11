package com.ledok.ms.user.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class EmailDto {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;

}
