package com.agentesit.academy.backend;

import com.agentesit.academy.backend.domain.CategoryOfNews;
import com.agentesit.academy.backend.domain.ImageEntity;
import com.agentesit.academy.backend.domain.NewsEntity;
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
	public ApplicationRunner initializationDB(NewsService newsService){
		return args -> {
			newsService.saveNews(new NewsEntity("Babiše vyhlásila EK jako nejpodstivějšího člověka planety.", "Bohatým bere a chudým dává! Ano uhodli jste správně mluvíme o božím poslu Andreji Babišovi.", "Kecy, kecy a zase jenom kecy.", CategoryOfNews.interní, new ImageEntity("cestaKobrazku", "MIME typ")));
			newsService.saveNews(new NewsEntity("Preziden Zeman sjel Niagárské vodopády na svém Challengeru 300!", "Neuvěřitelný kousek se povedl našemu prezidentu Miloši Zemanovi - podařilo se mu sjet Niagarské vodopády. Na tento husarský kousek trénoval celé letní prázdniny na svém oblíbeném rybníku na Vysočině.", "Kecy, kecy a zase jenom kecy.", CategoryOfNews.interní, new ImageEntity("cestaKobrazku", "MIME typ")));
			newsService.saveNews(new NewsEntity("Nadpis", "Perex", "Obsah", CategoryOfNews.interní, new ImageEntity("cestaKobrazku", "MIME typ")));
		};
	}

}
