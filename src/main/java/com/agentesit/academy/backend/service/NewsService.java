package com.agentesit.academy.backend.service;

import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.model.NewsFilter;
import com.agentesit.academy.backend.model.NewsLogics;
import com.agentesit.academy.backend.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/** Class managing data (News) between Controller and Repository. */
@Service
public class NewsService {

@Autowired
private NewsRepository newsRepository;

private NewsLogics newsLogics = new NewsLogics();

    /**
     * Save (INSERT) new news to database.
     * @param news News to save
     * @return Return the news that was saved.
     */
    public NewsEntity saveNews(NewsEntity news) {
        return newsRepository.save(news);
    }

//    public NewsEntity saveNews(NewsEntity news, MultipartFile file){
//        final String UPLOAD_DIR = "./src/main/resources/uploadsImages/";
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        // save the file on the local file system
//        try {
//            Path path = Paths.get(UPLOAD_DIR + fileName);
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    return newsRepository.save(news);
//}
public NewsEntity saveNews(NewsEntity news, MultipartFile file){
    final String UPLOAD_DIR = "./src/main/resources/uploadsImages/";

    Path path = newsLogics.saveFile(UPLOAD_DIR, file);

    news.getImage().setPathToImage(path.toString());
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

}


