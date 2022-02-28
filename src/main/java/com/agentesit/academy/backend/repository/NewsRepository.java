package com.agentesit.academy.backend.repository;

import com.agentesit.academy.backend.domain.NewsEntity;
import com.agentesit.academy.backend.model.NewsFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/** Repository interface of news */
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {


    @Query(value = "select n from news n where " +
            ":#{#newsFilter.getCategoryOfNews()} is null OR n.category = :#{#newsFilter.getCategoryOfNews()}")
    List<NewsEntity> getFiltredNews(@Param("newsFilter") NewsFilter newsFilter);


    Optional<NewsEntity> findById(Long id);

}
