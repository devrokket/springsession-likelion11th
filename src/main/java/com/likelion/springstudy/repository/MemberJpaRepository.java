package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    //방법3
    default Member findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 회원을 찾을 수 없습니다."));
    }

//    List<Member> findAllByIsDeleted() {
//
//    }

    // JPQL 사용하는 방법
    @Query("select m from Member m where m.isDeleted = false")
    List<Member> findAllNotDeleted();

    // JPA Query Methods 문서 참고
    @Modifying
    @Query("delete from Member m where m.isDeleted = true and m.deletedAt < now()")
    void deleteExpiredMember();


    /*
    Service - 영속성 컨텍스트 - DB
    Transaction이 끝날 때 DB에 접근
    @Modifying -> 영속성 컨텍스트 적용 안 되어 있기 때문에 주의
     */
}
