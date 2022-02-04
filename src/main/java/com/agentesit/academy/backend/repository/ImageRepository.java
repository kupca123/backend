package com.agentesit.academy.backend.repository;

import com.agentesit.academy.backend.domain.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
