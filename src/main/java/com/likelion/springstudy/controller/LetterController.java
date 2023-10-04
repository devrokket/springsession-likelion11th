package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion.springstudy.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/letter")
@RequiredArgsConstructor
public class LetterController {
    private final LetterService letterService;
    @PostMapping // 다음 parameter가 없을 땐 안 써줘도 됨
    public ResponseEntity<Void> sendLetter(@RequestBody LetterCreateRequest request) {
//        String letterId = letterService.create(request);
//        URI location = new URI.create("/api/letter/");

//        return ResponseEntity.created(location).build(); // created(location 자리)

    }

}
