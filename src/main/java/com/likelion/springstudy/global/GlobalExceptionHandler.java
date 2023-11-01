package com.likelion.springstudy.global;

import com.likelion.springstudy.global.exception.BusinessException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 애플리케이션 내 모든 컨트롤러에서 발생하는 예외처리를 아래 메소드들이 담당하게 된다.
// ControllerAdvide가 없다면 아래 ExceptionHandler 주석을 모든 컨트롤러마다 붙여줘야 한다.
public class GlobalExceptionHandler {

    /**
     * 실패 응답을 여기서 정의
     * 컨트롤러단에서 Exception을 처리할 필요가 없음. 성공에 대한 응답만 정의/
     */

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Void> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.notFound().build(); // ResponseEntity.notFound()
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().build(); // ResponseEntity.badRequest() 400 에러코드
    }

    /**
     * ResponseEntity에 따르면 badRequest는 무조건 400
     * 다른 케이스의 예외처리는 어떻게?
     * CustomException 활용.
     */

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Void> handleBuisinessException(BusinessException e) {
        return ResponseEntity.internalServerError().build();
    }

}
