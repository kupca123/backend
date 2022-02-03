package com.agentesit.academy.backend;

import com.agentesit.academy.backend.domain.CategoryOfNews;
import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.repository.NewsRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializationDB(NewsRepository newsRepository){
		return args -> {
			newsRepository.save(new NewsEntity("Nadpis", "Perex", "Obsah", CategoryOfNews.interní));
		};
	}

}
