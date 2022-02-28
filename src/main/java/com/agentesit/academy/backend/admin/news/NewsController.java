package com.agentesit.academy.backend.admin.news;

import com.agentesit.academy.backend.domain.CategoryOfNews;
import com.agentesit.academy.backend.domain.ImageEntity;
import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.model.NewsFilter;
import com.agentesit.academy.backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


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
    @GetMapping("/createNews")
    public String getCreateForm(@SessionAttribute("newsFilter") NewsFilter newsFilter, Model model){
        model.addAttribute("filter", newsFilter);
        model.addAttribute("typeOfView", "/admin/news/createNews");

//        // pak smazat!!!!!
//        System.out.println("URL adresa: " + request.getRequestURI());
//        ////// ----------

        model.addAttribute("news", new NewsEntity());
        model.addAttribute("image", new ImageEntity());
        model.addAttribute("categoryOfNews", CategoryOfNews.values());
        return "admin/news/create";
    }


@PostMapping("/createNews")
    public String postCreateNews(@ModelAttribute NewsEntity news, @RequestParam("imageInput") MultipartFile file, RedirectAttributes attributes) {

        // check if file is empty
    System.out.println("Cesta: " + news.getImage());
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/admin/news/createNews";
        }


//        news.setImage(image);
        newsService.saveNews(news, file);
        return "redirect:/admin/news";
    }

    @GetMapping("/editNews/{id}")
    public String getEditNews(@PathVariable Long id, Model model){
        model.addAttribute("typeOfView", "/admin/news/editNews");

        model.addAttribute("news", newsService.getNewsById(id).get());
        model.addAttribute("categoryOfNews", CategoryOfNews.values());

        return "admin/news/create";
    }

    @PostMapping("/editNews")
    public String postEditNews(@ModelAttribute NewsEntity news){
        newsService.saveNews(news);
        return "redirect:/admin/news";
    }

    @ModelAttribute("newsFilter")
    public NewsFilter getNewsFilter(){
        return new NewsFilter();
    }
}
