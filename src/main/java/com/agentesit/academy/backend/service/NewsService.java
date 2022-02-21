package com.agentesit.academy.backend.service;

import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.model.NewsFilter;
import com.agentesit.academy.backend.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Class managing data (News) between Controller and Repository. */
@Service
public class NewsService {

@Autowired
private NewsRepository newsRepository;

    /**
     * Save (INSERT) new news to database.
     * @param news News to save
     * @return Return the news that was saved.
     */
    public NewsEntity saveNews(NewsEntity news){
    return newsRepository.save(news);
}

    /**
     * Get all news from database.
     * @return Get all news from database.
     */
    public List<NewsEntity> getAllNews(){
        return newsRepository.findAll();
    }

    /**
     * Get filtered news.
     * @param newsFilter Filter for news
     * @return Get news filtered by category of news from database.
     */
    public List<NewsEntity> getFiltredNews(NewsFilter newsFilter) {
        return newsRepository.getFiltredNews(newsFilter);
    }

}


