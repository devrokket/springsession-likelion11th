package com.likelion.springstudy.domain.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "letter")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/**
 * @AllArgsConstructor : 클래스 내 '모든' 변수를 매개변수로 하여 생성자를 자동 생성
 * @NoArgsConstructor: 아무 매개변수가 없는 생성자를 자동 생성
 * 예, public Letter() {}
 */

/**
 * 기본 생성자는 왜 만들어야 할까?
 JPA는 Entity 객체를 인스턴스화 하고 필드에 값을 채워넣기 위해 Reflection을 사용한다.
 런타임 시점에 동적으로 기본생성자를 통해 클래스를 인스턴스화하여 값을 매핑한다.
 */

/**
 * 접근 레벨을 다음과 같이 설정할 수 있다.
 access = AccessLevel.PROTECTED
 access = AccessLevel.PRIVATE
 */
public class Letter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    /**
     * FetchType : 지연로딩과 즉시로딩
     Letter 엔티티를 조회할 때 Box 엔티티도 모두 조회할 필요는 없다.
     Letter를 로딩할 때 Box는 프록시로 로딩하고 만약 .getLetter().getBoxId() 처럼 Box의 필드를 조회할 때 로딩한다.

     만약 Letter를 조회할 때 Box 엔티티도 동시에 조회해야 한다면 즉시 로딩 FetchType.EAGER를 사용하자.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id")
    private Box box;

    /**
     * @Builder : 빌더 패턴 어노테이션
     * 생성자가 있는데 빌더 패턴을 사용하는 이유?
     * -> 필드 값이 많을 때 가독성 있게 정의할 수 있다.
     */
    @Builder
    public Letter(String title, String content, Box box) {
        this.title = title;
        this.content = content;
        this.box = box;
    }

}
