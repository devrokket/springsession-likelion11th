package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    //방법3
//    default MemberGetResponse findById()
}
