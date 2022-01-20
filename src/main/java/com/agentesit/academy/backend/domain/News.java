package com.agentesit.academy.backend.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class News extends Record {

    @NotBlank(message = "Title is mandatory!")
    @Size(max = 200)
    private String title;

    @NotBlank(message = "Perex is mandatory!")
    @Size(max = 450)
    private String perex;

    @NotBlank(message = "Content text is mandatory!")
    private String contentText;

    @NotNull
    private CategoryOfNews category;




    public News(Long id, LocalDateTime timeStampCreateRecord, LocalDateTime timeStampLastChangeOfRecord) {
        super(id, timeStampCreateRecord, timeStampLastChangeOfRecord);
    }
}
