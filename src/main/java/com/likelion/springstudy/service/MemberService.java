package com.likelion.springstudy.service;


import com.likelion.springstudy.domain.entity.Member;
import com.likelion.springstudy.dto.response.member.MemberGetResponseDto;
import com.likelion.springstudy.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // 생성자 방식 의존성 주입 위해
@Transactional(readOnly = true) // 영속성 컨텍스트. transactional 보장하여 요청에 따른 의도치 않은 db 변경 방지
public class MemberService {
    private final MemberJpaRepository memberRepository;

    // 방법1
    public MemberGetResponseDto getById(Long id) {
//        Member member = memberRepository.findById(id); // findById 메서드는 Optional이기 떄문에 이대로 쓰면 오류 발생.

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원을 찾을 수 없습니다."));
        return MemberGetResponseDto.of(member); // of()는 static 메서드기 때문에 따로 인스턴스를 만들지 않아도 바로 호출할 수 있다.
    }

    // 방법2
    private Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원을 찾을 수 없습니다."));
    }

    // 방법3 MemberJpaRepository단에서 메서드로 처리.
}
