package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.Box;
import com.likelion.springstudy.dto.request.box.BoxCreateRequestDto;
import com.likelion.springstudy.dto.response.box.BoxGetResponseDto;
import com.likelion.springstudy.dto.response.letter.LetterGetResponseDto;
import com.likelion.springstudy.repository.BoxJpaRepository;
import com.likelion.springstudy.repository.LetterJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Nodes.collect;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoxService {
    private final BoxJpaRepository boxJpaRepository;
    private final LetterJpaRepository letterJpaRepository;
    @Transactional
    public String create(BoxCreateRequestDto boxCreateRequest, Member) {
        // memberId, code도 불러와야 한다.
        Box box = boxJpaRepository.save(Box.builder()
                .name(boxCreateRequest.getName())
                // .code(generateCode())
                        // .Member
                .build());
        return box.getId().toString();
    }

    private String generateCode() {

    }

    public BoxGetResponseDto getByCode(String boxCode) {
        Box box = boxJpaRepository.findByCodeOrThrow(boxCode);
        List<LetterGetResponseDto> letters = letterJpaRepository.findAllByBox(box).stream()
                .map(LetterGetResponseDto::of)
                .collect(Collectors.toList()); // 리스트로 다시 변환
        return BoxGetResponseDto.of(box, letters);
    }

    @Transactional(readOnly = true)
    public List<BoxGetResponseDto> getAll() {
        List<Box> boxList = boxJpaRepository.findAll();
        return boxList.stream().map(BoxGetResponseDto::of).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoxGetResponseDto getById(Long boxId) {
        Box box =  boxJpaRepository.findById(boxId)
                .orElseThrow(() -> new EntityNotFoundException("해당 편지함을 조회할 수 없습니다."));
        return BoxGetResponseDto.of(box);
    }


}
