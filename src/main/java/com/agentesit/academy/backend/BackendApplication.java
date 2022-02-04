package com.agentesit.academy.backend;

import com.agentesit.academy.backend.domain.CategoryOfNews;
import com.agentesit.academy.backend.domain.ImageEntity;
import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.repository.NewsRepository;
import com.agentesit.academy.backend.service.NewsService;
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
	public ApplicationRunner initializationDB(NewsRepository newsRepository, NewsService newsService){
		return args -> {
//			newsRepository.save(new NewsEntity("Nadpis", "Perex", "Obsah", CategoryOfNews.interní));
			newsService.saveNews(new NewsEntity("Nadpis", "Perex", "Obsah", CategoryOfNews.interní, new ImageEntity("cestaKobrazku", "MIME typ")));
		};
	}

}
