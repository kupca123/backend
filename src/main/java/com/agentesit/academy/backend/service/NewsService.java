package com.agentesit.academy.backend.service;

import com.agentesit.academy.backend.domain.ImageEntity;
import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.model.NewsFilter;
import com.agentesit.academy.backend.model.NewsLogics;
import com.agentesit.academy.backend.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/** Class managing data (News) between Controller and Repository. */
@Service
public class NewsService {

@Autowired
private NewsRepository newsRepository;

private NewsLogics newsLogics = new NewsLogics();

private String rootDir = "./src/main/resources/static";
    
    
    /**
     * Save (INSERT) new news to database.
     * @param news News to save
     * @return Return the news that was saved.
     */
    public NewsEntity saveNews(NewsEntity news) {

        Path pathToImage = Paths.get(rootDir + news.getImage().getPathToImage());
        news.getImage().setMimeType(newsLogics.checkMIMEtype(pathToImage));
        return newsRepository.save(news);
    }


public NewsEntity saveNews(NewsEntity news, MultipartFile file){
    String uploadDir = "/uploadsImages/";

    Path path = newsLogics.saveFile(rootDir, uploadDir, file);


    news.setImage(new ImageEntity());
    news.getImage().setPathToImage(uploadDir + path.getFileName().toString());
    news.getImage().setMimeType(newsLogics.checkMIMEtype(path));
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

    public Optional<NewsEntity> getNewsById(Long id){
        return newsRepository.findById(id);
    }


}


