package com.likelion.springstudy.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member")
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String nickname;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = true, name = "is_deleted")
    private Boolean isDeleted;

    @Column(nullable = true, name = "deleted_at")
    private LocalDate deleteAt;
    /**
     * 일대일 관계 매핑할 때는 두 테이블 어느 곳에나 외래 키를 둘 수 있습니다.
     * 익명편지함 서비스를 생각해봤을 때 Member가 Box를 조회할 수도 있지만 Box에서도 Member를 조회할 수 있어야 합니다.
     * Member과 Box 모두 외래 키를 두어 양방향으로 접근이 가능할 수 있도록 외래키를 양쪽에 두었습니다.
     */
    @OneToOne
    @JoinColumn(name="box_id")
    private BoxEntity box;

    @Builder
    public MemberEntity(Long id, String name, String password, String nickname) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
    }
}
