package com.agentesit.academy.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "news")
public class NewsEntity extends Record {

    /** Title of news */
    @Column(nullable = false, length = 200)
    private String title;

    /** Perex of news */
    @Column(nullable = false, length = 450)
    private String perex;

    /** Content of news */
    @Column(nullable = false)
    private String contentText;

    /** Category of news */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryOfNews category;

    //Add foreign key from class "Images"

    // Constructor
    public NewsEntity() {
    }


    // Getters and Setters

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
