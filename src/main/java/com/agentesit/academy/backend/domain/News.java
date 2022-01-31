package com.agentesit.academy.backend.domain;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class News extends Record {

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 450)
    private String perex;

    @Column(nullable = false)
    private String contentText;

    @Column(nullable = false)
    private CategoryOfNews category;



}
