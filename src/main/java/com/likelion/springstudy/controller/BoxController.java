package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.request.box.BoxCreateRequestDto;
import com.likelion.springstudy.dto.response.box.BoxGetResponseDto;
import com.likelion.springstudy.service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/box")
@RequiredArgsConstructor
public class BoxController {
    private final BoxService boxService;

    // memberId와 함께 편지함 생성하는 api 주석 처리
/*    @PostMapping
    public ResponseEntity<String> createBox(@RequestBody BoxCreateRequestDto boxCreateRequest, Long memberId) {
        String createdBoxId = boxService.create(boxCreateRequest, memberId);
        URI location = URI.create("/api/letter/" + createdBoxId);
        return ResponseEntity.created(location).build();
    }*/
    @PostMapping
    public ResponseEntity<String> createBox(@RequestBody BoxCreateRequestDto boxCreateRequest) {
        String createdBoxId = boxService.create(boxCreateRequest);
        URI location = URI.create("/api/box/" + createdBoxId);
        return ResponseEntity.created(location).build();
    }

//    @GetMapping
//    public ResponseEntity<List<BoxGetResponseDto>> getBoxList() {
//        return ResponseEntity.ok(boxService.getAll());
//    }

//    @GetMapping("/{boxId}")
//    public ResponseEntity<BoxGetResponseDto> getBox(@PathVariable Long boxId) {
//        return ResponseEntity.ok(boxService.getById(boxId));
//    }

    @GetMapping("/{boxCode}")
    public ResponseEntity<BoxGetResponseDto> getBoxByCode(@PathVariable String boxCode) { return ResponseEntity.ok(boxService.getByCode(boxCode));}

}
