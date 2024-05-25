package by.prokopovich.switter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing//включение механизма слушателей над Entity-компонентами приложения
public class SwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwitterApplication.class, args);
    }

}
