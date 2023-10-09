package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.request.box.BoxCreateRequestDto;
import com.likelion.springstudy.dto.response.box.BoxGetResponseDto;
import com.likelion.springstudy.service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/box")
@RequiredArgsConstructor
public class BoxController {
    private final BoxService boxService;
    @PostMapping
    public ResponseEntity<String> createBox(@RequestBody BoxCreateRequestDto boxCreateRequest) {
        return ResponseEntity.ok(boxService.create(boxCreateRequest));
    }

    @GetMapping
    public ResponseEntity<List<BoxGetResponseDto>> getBoxList() {
        return ResponseEntity.ok(boxService.getAll());
    }

    @GetMapping("/{boxId}")
    public ResponseEntity<BoxGetResponseDto> getBox(@PathVariable Long boxId) {
        return ResponseEntity.ok(boxService.get(boxId));
    }

}
