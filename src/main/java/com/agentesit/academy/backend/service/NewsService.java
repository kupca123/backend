package com.agentesit.academy.backend.service;

import com.agentesit.academy.backend.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Class managing data (News) between Controller and Repository. */
@Service
public class NewsService {

@Autowired
private NewsRepository newsRepository;



}
