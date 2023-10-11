package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.response.member.MemberGetResponseDto;
import com.likelion.springstudy.dto.response.member.MemberSigninRequest;
import com.likelion.springstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController // serialzier 기능을 갖춘 클래스. @ResponseBody + @Controller
@RequestMapping("/api/member")
@RequiredArgsConstructor // final키워드를 붙인 변수들의 생성자를 만들어줌. spring에서 권장한 방법
public class MemberController {

    private final MemberService memberService; // 의존성 주입 3개 방법 중 가장 많이 쓰이는 [생성자 주입 방식] private, final로 변화에 안전하기 때문

    @PostMapping
    public ResponseEntity<Void> signIn(@RequestBody MemberSigninRequest request) {
        URI location = URI.create("/api/member/" + memberService.create(request));
        return ResponseEntity.created(location).build();
    }
    @GetMapping("{memberId}")
    // 반환형은 ResponseEntity(스프링 제공), CustomResponse(추상화를 꼭 해야한다. 여러 api에서 사용돼야 하기 때문이다)
    // ResponseEntity<MemberGetResponse> 제네릭 타입 사용. 응답값은 api마다 달라지기 때문
    public ResponseEntity<MemberGetResponseDto> getMember(@PathVariable("memberId") Long memberid) // {memberId} 들어온 값을 Long형의 memberId로 변환해줌
    {
        return ResponseEntity.ok(memberService.getById(memberid)); // ResponseEntity.ok(성공한 케이스의 응답을 넣어줌)
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> withdrawMembership(@PathVariable("memberId") Long memberId) {
        memberService.deleteById(memberId);
        return ResponseEntity.ok().build();
    }

    @PostMapping // is_deleted, deleted_at만 수정하는 것이기 때문에 patch 메서드가 맞을 수도 있음. POST MAPPING이 수정할 때도 사용되긴 함.
    public ResponseEntity<Void> recoverMembership(@PathVariable("memberId") Long memberId) {
        memberService.recoverMemberInfo(memberId);
        return ResponseEntity.ok().build();
    }

}
