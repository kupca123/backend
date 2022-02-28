package com.agentesit.academy.backend.model;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NewsLogics {



    public Path saveFile(String rootDir, String uploadDir, MultipartFile file){
//        final String UPLOAD_DIR = "./src/main/resources/static" + uploadDir;
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = null;

        // save the file on the local file system
        try {
            path = Paths.get(rootDir + uploadDir + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    public String checkMIMEtype(Path pathOfFile) {

        String mimeType = "";

        try {
           mimeType = Files.probeContentType(pathOfFile);
        } catch(IOException e) {
            e.printStackTrace();
        }

        return mimeType;
    }


}
