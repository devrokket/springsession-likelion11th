package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.domain.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter // 일반적으로 Getter 어노테이션만 사용. Setter 사용 지양. 필요할 때만 사용. 비즈니스 로직에서 생성해주는 일이 많기 때문.
@Table(name = "member")
/**
//@Where(clause = "is_deleted = false") // JPA에서 굳이 돌릴 필요 없도록 Member를 조회할 때 삭제되지 않은 회원만 조회하는 어노티
//@SQLDelete(sql = "Update member seet is_deleted = true, deleted_at = now()+30 where id = ?") // JPA에서 삭제가 진행될 때 SQLDELETE 안의 문장이 실행됨.
// 만약 역대 회원을 조회한다고 하면 ? 어노티 사용할 수 없음. 실무에서 많이 쓰이진 않음.
 */
public class Member extends BaseTimeEntity {
    private static final Long MEMBER_INFO_RETENTION_PERIOD = 30L;


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 생성자
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String nickname;

    private boolean isDeleted;
    private LocalDateTime deletedAt;

    @Builder
    public Member(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public static Member createMember(String name, String nickname) {
        return new Member(name, nickname);
    }

    public void softDelete() {
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now().plusDays(MEMBER_INFO_RETENTION_PERIOD); // 30일을 정의해서 불러오는 방법

//        this.deletedAt = LocalDateTime.now().plusDays(30); // 30일 뒤에 삭제
    }

    // 회원 정보 삭제 후 다시 복구할 때 사용
    public void recover() {
        this.isDeleted = false;
        this.deletedAt = null;
    }
}
