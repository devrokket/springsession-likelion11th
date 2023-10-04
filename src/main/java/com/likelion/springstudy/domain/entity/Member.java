package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.domain.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter // 일반적으로 Getter 어노테이션만 사용. Setter 사용 지양. 필요할 때만 사용. 비즈니스 로직에서 생성해주는 일이 많기 때문.
@Table(name = "member")
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 생성자
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String nickname;

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
}
