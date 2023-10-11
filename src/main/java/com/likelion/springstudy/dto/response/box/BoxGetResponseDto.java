package com.likelion.springstudy.dto.response.box;

import com.likelion.springstudy.domain.entity.Box;
import com.likelion.springstudy.dto.response.letter.LetterGetResponseDto;

import java.util.List;

public record BoxGetResponseDto(
        String name,
        List<LetterGetResponseDto> letters
) {

    public static BoxGetResponseDto of(Box box, List<LetterGetResponseDto> letters) {
        return new BoxGetResponseDto(box.getName(), letters);
    }
}
