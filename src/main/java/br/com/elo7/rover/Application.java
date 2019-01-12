package br.com.elo7.rover;

import br.com.elo7.rover.domain.service.MarsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.Serializable;

/**
 * SpringBoot Starter class.
 *
 * @author Daniel Vicente
 * @since 1.0
 */
@SpringBootApplication
public class Application implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        final DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return dispatcherServlet;
    }

    @Bean
    public MarsService marsService() {
        return new MarsService();
    }
}
