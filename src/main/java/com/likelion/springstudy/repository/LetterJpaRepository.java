package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterJpaRepository extends JpaRepository<Letter, Long> {
}
