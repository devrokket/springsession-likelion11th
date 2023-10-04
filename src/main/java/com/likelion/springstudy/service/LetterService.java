package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.Letter;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion.springstudy.repository.LetterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {
    private final LetterJpaRepository letterJpaRepository;

    @Transactional
    public void create(LetterCreateRequest letterCreateRequest) {
        // create 방법 1
        letterJpaRepository.save(LetterCreateRequest.toLetter(letterCreateRequest.getTitle(), letterCreateRequest.getContent()));

        letterJpaRepository.save(Letter.builder()
                .title(letterCreateRequest.getTitle())
                .content(letterCreateRequest.getContent())
                .build());
        return letter.getId().toS
    }
}
