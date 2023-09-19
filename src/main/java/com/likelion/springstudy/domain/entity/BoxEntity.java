package com.likelion.springstudy.domain.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "letter_box")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoxEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private int letterLimit;

    private String code;

    @OneToOne(mappedBy = "box")
    private MemberEntity member;

    @OneToMany(mappedBy = "box")
    private List<LetterEntity> letters = new ArrayList<>();

    @Builder
    public BoxEntity(String name, int letterLimit) {
        this.name = name;
        this.letterLimit = letterLimit;
    }
}
