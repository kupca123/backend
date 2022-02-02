package com.agentesit.academy.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "image")
public class ImageEntity {

    /** Relative path to image on the disk */
    @Column(nullable  =  false)
    private String pathToImage;

    /** MIME type of file */
    @Column(nullable  =  false)
    private String mimeType;

    // Constructor
    public ImageEntity() {
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