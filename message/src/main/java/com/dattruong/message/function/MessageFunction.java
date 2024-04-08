package com.dattruong.message.function;

import com.dattruong.message.dto.AccountMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunction {
    private static  final Logger log = LoggerFactory.getLogger(MessageFunction.class);

    @Bean
    public Function <AccountMsgDto, AccountMsgDto> email() {
        return accountMsgDto -> {
            log.info("Sending email with the details : " +  accountMsgDto.toString());
            return accountMsgDto;
        };
    }
}
