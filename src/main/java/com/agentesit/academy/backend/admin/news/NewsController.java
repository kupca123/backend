package com.agentesit.academy.backend.admin.news;


import com.agentesit.academy.backend.domain.CategoryOfNews;
import com.agentesit.academy.backend.model.NewsFilter;
import com.agentesit.academy.backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for News.
 */
@Controller
@RequestMapping("/admin/news")
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
    public String getFiltredNews(NewsFilter newsFilter, Model model) {
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
    @GetMapping("/createNews")
    public String getCreateForm(){
        return "admin/news/create";
    }
}
