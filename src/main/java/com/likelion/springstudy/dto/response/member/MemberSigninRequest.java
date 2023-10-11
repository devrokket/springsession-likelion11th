package com.likelion.springstudy.dto.response.member;

/**
 * 레코드
 * DTO 만드는 현대적 방법 (Java 17부터 지원)
 * parameter 형식으로 넣어줌
 * 생성자, 제어자 필요 없음
 */
public record MemberSigninRequest (
        String username,
        String password,
        String nickname
) {
}