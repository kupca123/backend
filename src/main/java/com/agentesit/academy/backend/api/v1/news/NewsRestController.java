package com.agentesit.academy.backend.api.v1.news;

import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest Controller class for News.
 */
@RestController
@RequestMapping("/api/v1/news")
public class NewsRestController {

    /** Instance of NewsService class */
    @Autowired
    private NewsService newsService;

    /**
     * Get all news from database.
     * @return Get List of news from database.
     */
    @GetMapping
    public List<NewsEntity> getAllNews(){
        return newsService.getAllNews();
    }
}
