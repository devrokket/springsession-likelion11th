package com.likelion.springstudy.dto.response.letter;

import com.likelion.springstudy.domain.entity.Box;
import com.likelion.springstudy.domain.entity.Letter;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LetterGetResponseDto {
    private String title;
    private String content;

    /**
     * 생성패턴 2. 팩토리 메서드 패턴
     * 메서드 이름을 자유롭게 정할 수 있다. 일반 생성자는 클래스의 이름과 일치해야 하지만, 목적에 따라 정의할 수 있음. (ex, getLetter)
     * of, from 이름의 메서드를 사용하는 것이 일반적.
     */
    public static LetterGetResponseDto of(Letter letter) {
        return new LetterGetResponseDto(letter.getTitle(), letter.getContent());
    }

}
