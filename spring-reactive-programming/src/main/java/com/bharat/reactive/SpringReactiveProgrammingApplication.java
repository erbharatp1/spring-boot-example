package com.bharat.reactive;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringReactiveProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveProgrammingApplication.class, args);
	}

    @Bean
    ApplicationRunner init(TodoRepository repository, DatabaseClient client) {
        return args -> {
            client.execute("create table IF NOT EXISTS TODO" +
                    "(id SERIAL PRIMARY KEY, text varchar (255) not null, completed boolean default false);").fetch().first().subscribe();
            client.execute("DELETE FROM TODO;").fetch().first().subscribe();

            Stream<Todo> stream = Stream.of(new Todo(null, "Hi this is my first todo!", false),
                    new Todo(null, "This one I have acomplished!", true),
                    new Todo(null, "And this is secret", false));

            // initialize the database

            repository.saveAll(Flux.fromStream(stream))
                    .then()
                    .subscribe(); // execute

        };
    }
}
