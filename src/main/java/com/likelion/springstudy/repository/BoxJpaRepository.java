package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoxJpaRepository extends JpaRepository<Box, Long> { // <Entity, pk-type>

    default Box findByCodeOrThrow(String code) {
        return findByCode(code).orElseThrow(() -> new IllegalArgumentException("해당 박스가 존재하지 않습니다."));
    }

    Optional<Box> findByCode(String code);

}
