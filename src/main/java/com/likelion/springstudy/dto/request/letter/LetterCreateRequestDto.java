package com.likelion.springstudy.dto.request.letter;

import com.likelion.springstudy.domain.entity.Box;
import com.likelion.springstudy.domain.entity.Letter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본 생성자가 있어야 Jackson 라이브러리가 직렬화, 역직렬화를 할 수 있음
public class LetterCreateRequestDto {
    private String title;
    private String content;
    private Long boxId; // 편지함 id
}
