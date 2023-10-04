package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.response.member.MemberGetResponse;
import com.likelion.springstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // serialzier 기능을 갖춘 클래스. @ResponseBody + @Controller
@RequestMapping("/api/member")
@RequiredArgsConstructor // final로 정의한 변수들만 생성자를 만든다.
public class MemberController {
    private final MemberService memberService; // 의존성 주입 3개 방법 중 가장 많이 쓰이는 [생성자 주입 방식] private, final로 변화에 안전하기 때문
    @GetMapping("{memberId}")
    // 반환형은 ResponseEntity(스프링 제공), CustomResponse(추상화를 꼭 해야한다. 여러 api에서 사용돼야 하기 때문이다)
    // ResponseEntity<MemberGetResponse> 제네릭 타입 사용. 응답값은 api마다 달라지기 때문
    public ResponseEntity<MemberGetResponse> getMember(@PathVariable("memberId") Long memberid) // {memberId} 들어온 값을 Long형의 memberId로 변환해줌
    {
        return ResponseEntity.ok(memberService.getById(memberid));

    }
}
