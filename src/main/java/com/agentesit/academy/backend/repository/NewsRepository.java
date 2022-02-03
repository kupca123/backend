package com.agentesit.academy.backend.repository;

import com.agentesit.academy.backend.domain.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repository interface of news */
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
}
