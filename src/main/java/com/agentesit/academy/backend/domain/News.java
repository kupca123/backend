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


    public News() {
    }
}
