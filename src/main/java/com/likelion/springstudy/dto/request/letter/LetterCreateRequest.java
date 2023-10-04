package com.likelion.springstudy.dto.request.letter;

import com.likelion.springstudy.domain.entity.Letter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LetterCreateRequest {
    private String title;
    private String content;

    public static Letter toLetter(String title, String content) {
        return new Letter(title, content);
    }
}
