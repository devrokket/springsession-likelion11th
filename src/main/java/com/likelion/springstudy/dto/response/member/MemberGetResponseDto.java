package com.likelion.springstudy.dto.response.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.likelion.springstudy.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberGetResponseDto {
    // {memberId}는 이미 조회할 때 알고 있기에 Response로 받을 필요 없음
    @JsonProperty("멤버 이름") // 컴파일 하면 key 값에 '멤버 이름'이 표시됨
    private String name;

    @JsonProperty("닉네임")
    private String nickname;

    public static MemberGetResponseDto of(Member member) { // of 또는 from 메서드를 사용
        return new MemberGetResponseDto(member.getName(), member.getNickname());
    }
}
