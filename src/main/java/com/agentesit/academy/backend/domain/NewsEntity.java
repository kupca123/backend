package com.agentesit.academy.backend.domain;

import javax.persistence.*;

@Entity(name = "news")
@SequenceGenerator(sequenceName = "news_id_seq", name = "record_seq_gen", allocationSize = 1)
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


    /** Foreign key (reference) of image */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private ImageEntity image;

    // Constructor
    public NewsEntity() {
    }

    public NewsEntity(String title, String perex, String contentText, CategoryOfNews category, ImageEntity image) {
        this.title = title;
        this.perex = perex;
        this.contentText = contentText;
        this.category = category;
        this.image = image;
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
