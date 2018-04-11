package cn.linkedcare.config;

import cn.linkedcare.service.MessageService;
import cn.linkedcare.service.impl.MessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 张恒 on 2018/4/8.
 */
@Configuration
public class MessageConfig {

    @Bean(name = "messageService")
    public MessageService messageService() {
        return new MessageServiceImpl();
    }

}
