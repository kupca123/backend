package com.agentesit.academy.backend.admin.news;


import com.agentesit.academy.backend.domain.CategoryOfNews;
import com.agentesit.academy.backend.domain.ImageEntity;
import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.model.NewsFilter;
import com.agentesit.academy.backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Controller class for News.
 */
@Controller
@RequestMapping("/admin/news")
@SessionAttributes("newsFilter")
public class NewsController {

    /** Instance of NewsService class */
    @Autowired
    private NewsService newsService;

    /**
     * Get all news from database and transmit it to Model.
     * @return ThymeLeaf template "list.html" with transmitted news in Model.
     */
//    @GetMapping()
//    public String getAllNews(Model model){
//        model.addAttribute("listOfNews", newsService.getAllNews());
//        model.addAttribute("categoryOfNews", CategoryOfNews.values());
//        return "admin/news/list";
//    }

    /**
     * Gets news from the database by filter. If no filter is set, it will return all news
     * @param newsFilter Based on this parameter, news is filtered.
     * @param model Access data for Thymeleaf
     * @return list.html
     */
    @GetMapping
    public String getFiltredNews(@ModelAttribute("newsFilter") NewsFilter newsFilter, Model model) {
        model.addAttribute("categoryOfNews", CategoryOfNews.values());
        if(newsFilter != null) {
            model.addAttribute("listOfNews", newsService.getFiltredNews(newsFilter));
        }else{
            model.addAttribute("listOfNews", newsService.getAllNews());
        }
        return "admin/news/list";
    }

    /**
     * Route to blank create.html form.
     * @return create.html
     */
//    @GetMapping("/createNews")
//    public String getCreateForm(){
//        return "admin/news/create";
//    }

    @GetMapping("/createNews")
    public String getCreateForm(@SessionAttribute("newsFilter") NewsFilter newsFilter, Model model){
        model.addAttribute("filter", newsFilter);

        model.addAttribute("news", new NewsEntity());
        model.addAttribute("image", new ImageEntity());
        model.addAttribute("categoryOfNews", CategoryOfNews.values());
        return "admin/news/create";
    }

//    @PostMapping("/createNews")
//    public String postCreateNews(@ModelAttribute NewsEntity news, @ModelAttribute ImageEntity image) {
//        news.setImage(image);
//        newsService.saveNews(news);
//        return "redirect:/admin/news";
//    }

//    @PostMapping("/createNews")
//    public String postCreateNews(@ModelAttribute NewsEntity news, @ModelAttribute ImageEntity image, @RequestParam("imageInput") MultipartFile file, RedirectAttributes attributes) {
//        final String UPLOAD_DIR = "./src/main/resources/uploadsImages/";
//
//        // check if file is empty
//        if (file.isEmpty()) {
//            attributes.addFlashAttribute("message", "Please select a file to upload.");
//            return "redirect:/admin/news/createNews";
//        }
//
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        // save the file on the local file system
//        try {
//            Path path = Paths.get(UPLOAD_DIR + fileName);
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        news.setImage(image);
//        newsService.saveNews(news);
//        return "redirect:/admin/news";
//    }

 @PostMapping("/createNews")
    public String postCreateNews(@ModelAttribute NewsEntity news, @ModelAttribute ImageEntity image, @RequestParam("imageInput") MultipartFile file, RedirectAttributes attributes) {
//        final String UPLOAD_DIR = "./src/main/resources/uploadsImages/";

        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/admin/news/createNews";
        }

//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        // save the file on the local file system
//        try {
//            Path path = Paths.get(UPLOAD_DIR + fileName);
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        news.setImage(image);
        newsService.saveNews(news, file);
        return "redirect:/admin/news";
    }


    @ModelAttribute("newsFilter")
    public NewsFilter getNewsFilter(){
        return new NewsFilter();
    }
}
