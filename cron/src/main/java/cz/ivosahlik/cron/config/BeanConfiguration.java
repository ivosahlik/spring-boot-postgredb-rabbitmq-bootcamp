package cz.ivosahlik.cron.config;

import cz.ivosahlik.clamav.CheckService;
import cz.ivosahlik.clamav.CheckServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CheckService checkService() {
        return new CheckServiceImpl();
    }
}
