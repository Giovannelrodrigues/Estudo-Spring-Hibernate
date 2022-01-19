package br.com.giovanneestudocontmatic.estudocontmatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.giovanneestudocontmatic.estudocontmatic.domain"})
public class EstudoContmaticApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudoContmaticApplication.class, args);
    }

}
