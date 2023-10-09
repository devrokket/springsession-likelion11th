package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.Box;
import com.likelion.springstudy.domain.entity.Letter;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequestDto;
import com.likelion.springstudy.dto.response.letter.LetterGetResponseDto;
import com.likelion.springstudy.repository.BoxJpaRepository;
import com.likelion.springstudy.repository.LetterJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {
    private final LetterJpaRepository letterJpaRepository;
    private final BoxJpaRepository boxJpaRepository;

    // 편지 생성
    @Transactional
    public String create(LetterCreateRequestDto letterCreateRequest) {
        Long boxId = letterCreateRequest.getBoxId();

        /**
         * Request의 boxId로 해당 편지함 조회
         */
        Box box = boxJpaRepository.findById(boxId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 편지함 id: " + boxId));

        Letter letter = letterJpaRepository.save(Letter.builder()
                .title(letterCreateRequest.getTitle())
                .content(letterCreateRequest.getContent())
                .box(box)
                .build());
        return letter.getId().toString();
    }

    // 편지 목록 조회
    public List<Letter> getAll() {
        return letterJpaRepository.findAll();
    }

    // 편지 id 조회
    public LetterGetResponseDto get(Long letterId) {
        Letter letter = letterJpaRepository.findById(letterId)
                .orElseThrow(() -> new EntityNotFoundException(("해당하는 편지를 찾을 수 없습니다.")));
        return LetterGetResponseDto.of(letter);
    }
}
