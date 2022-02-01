package com.agentesit.academy.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class News extends Record {

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 450)
    private String perex;

    @Column(nullable = false)
    private String contentText;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryOfNews category;

    //Add foreign key from class "Images"



    public News() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerex() {
        return perex;
    }

    public void setPerex(String perex) {
        this.perex = perex;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public CategoryOfNews getCategory() {
        return category;
    }

    public void setCategory(CategoryOfNews category) {
        this.category = category;
    }
}
