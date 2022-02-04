package com.agentesit.academy.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "image")
public class ImageEntity extends Record {

    /** Relative path to image on the disk */
    @Column(nullable  =  false)
    private String pathToImage;

    /** MIME type of file */
    @Column(nullable  =  false)
    private String mimeType;

    /** Relationship on NewsEntity */
    @OneToOne(mappedBy = "image")
    private NewsEntity news;


    // Constructor
    public ImageEntity() {
    }

    public ImageEntity(String pathToImage, String mimeType) {
        this.pathToImage = pathToImage;
        this.mimeType = mimeType;
    }

    // Getters and Setters

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
