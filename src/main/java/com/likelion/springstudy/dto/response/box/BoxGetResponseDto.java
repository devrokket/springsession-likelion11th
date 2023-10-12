package com.likelion.springstudy.dto.response.box;

import com.likelion.springstudy.domain.entity.Box;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BoxGetResponseDto {
    private String name;

    public static BoxGetResponseDto of(Box box) {
        return new BoxGetResponseDto(box.getName());
    }
}
