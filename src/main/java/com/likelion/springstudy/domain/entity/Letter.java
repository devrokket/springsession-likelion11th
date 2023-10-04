package com.likelion.springstudy.domain.entity;


import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "letter")
@Builder
public class Letter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    // 생성자
    public Letter(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "box_id")
    private Box box;
//    @Column(nullable = false, name = "photo_url")
//    private String photoUrl;
//
//    @CreatedDate
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;

}
