package com.likelion.springstudy.controller;


import com.likelion.springstudy.domain.entity.Letter;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequestDto;
import com.likelion.springstudy.dto.response.letter.LetterGetResponseDto;
import com.likelion.springstudy.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/letter")
@RequiredArgsConstructor
public class LetterController {
    private final LetterService letterService;
    @PostMapping // 다음 parameter가 없을 땐 안 써줘도 됨
    public ResponseEntity<String> sendLetter(@RequestBody LetterCreateRequestDto letterCreateRequest) {
        String createdLetterId = letterService.create(letterCreateRequest);
        URI location = URI.create("/api/letter/" + createdLetterId);
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<LetterGetResponseDto>> getAllLetter() {
        return ResponseEntity.ok(letterService.getAll());
    }

    @GetMapping("/{letterId}")
    public ResponseEntity<LetterGetResponseDto> getLetter(@PathVariable("letterId") Long letterId) {
        return ResponseEntity.ok(letterService.get(letterId));
    }
}
