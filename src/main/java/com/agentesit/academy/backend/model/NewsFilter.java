package com.agentesit.academy.backend.model;

import com.agentesit.academy.backend.domain.CategoryOfNews;

public class NewsFilter {
    private CategoryOfNews categoryOfNews;

    public CategoryOfNews getCategoryOfNews() {
        return categoryOfNews;
    }

    public void setCategoryOfNews(CategoryOfNews categoryOfNews) {
        this.categoryOfNews = categoryOfNews;
    }
}
