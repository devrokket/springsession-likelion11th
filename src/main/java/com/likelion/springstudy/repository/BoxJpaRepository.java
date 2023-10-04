package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxJpaRepository extends JpaRepository<Box, Long> { // <Entity, pk-type>

}
