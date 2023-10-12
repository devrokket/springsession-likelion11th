package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.Box;
import com.likelion.springstudy.domain.entity.Member;
import com.likelion.springstudy.dto.request.box.BoxCreateRequestDto;
import com.likelion.springstudy.dto.response.box.BoxGetResponseDto;
import com.likelion.springstudy.dto.response.letter.LetterGetResponseDto;
import com.likelion.springstudy.repository.BoxJpaRepository;
import com.likelion.springstudy.repository.LetterJpaRepository;
import com.likelion.springstudy.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoxService {
    private final BoxJpaRepository boxJpaRepository;
    private final LetterJpaRepository letterJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    @Transactional
    public String create(BoxCreateRequestDto boxCreateRequest, Long memberId) {
        // memberId, code도 불러와야 한다.
        Box box = boxJpaRepository.save(Box.builder()
                .name(boxCreateRequest.getName())
                .code(generateCode())
                .member(findMemberById(memberId))
                .build());
        return box.getCode();
    }

    // UUID의 8자리까지만 이용하여 boxCode 생성. 10^8의 서로 다른 코드 생성이 가능함
    private String generateCode() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public BoxGetResponseDto getByCode(String boxCode) {
        Box box = boxJpaRepository.findByCodeOrThrow(boxCode);
        List<LetterGetResponseDto> letters = letterJpaRepository.findAllByBox(box)
                .stream()
                .map(LetterGetResponseDto::of)
                .collect(Collectors.toList()); // 리스트로 다시 변환
        return BoxGetResponseDto.of(box, letters);
    }


    private Member findMemberById(Long memberId) {
        return memberJpaRepository.findByIdOrThrow(memberId);
    }
}
