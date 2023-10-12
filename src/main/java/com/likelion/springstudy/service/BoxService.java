package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.Box;
import com.likelion.springstudy.dto.request.box.BoxCreateRequestDto;
import com.likelion.springstudy.dto.response.box.BoxGetResponseDto;
import com.likelion.springstudy.repository.BoxJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoxService {
    private final BoxJpaRepository boxJpaRepository;
    @Transactional
    public String create(BoxCreateRequestDto boxCreateRequest) {
        Box box = boxJpaRepository.save(Box.builder()
                .name(boxCreateRequest.getName())
                .build());
        return box.getId().toString();
    }

    @Transactional(readOnly = true)
    public List<BoxGetResponseDto> getAll() {
        List<Box> boxList = boxJpaRepository.findAll();
        return boxList.stream().map(BoxGetResponseDto::of).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoxGetResponseDto get(Long boxId) {
        Box box =  boxJpaRepository.findById(boxId)
                .orElseThrow(() -> new EntityNotFoundException("해당 편지함을 조회할 수 없습니다."));
        return BoxGetResponseDto.of(box);
    }


}
