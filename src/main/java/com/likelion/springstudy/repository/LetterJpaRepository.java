package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.Box;
import com.likelion.springstudy.domain.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterJpaRepository extends JpaRepository<Letter, Long> {
    List<Letter> findAllByBox(Box box);

}
