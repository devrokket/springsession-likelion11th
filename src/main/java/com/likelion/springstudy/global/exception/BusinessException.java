package com.likelion.springstudy.global.exception;

/*
자바의 모든 Exception은 상위 클래서가 RuntimeException
 */
public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }
}
