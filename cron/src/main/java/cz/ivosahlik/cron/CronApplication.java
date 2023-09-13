package cz.ivosahlik.cron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("cz.ivosahlik.*")
@EntityScan(basePackages = {"cz.ivosahlik.*"})
@SpringBootApplication
public class CronApplication {

    public static void main(String[] args) {
        SpringApplication.run(CronApplication.class, args);
    }

}
