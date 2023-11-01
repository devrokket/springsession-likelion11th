package com.likelion.springstudy.global.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

/**
 * EC2에 배포했을 때 시간이 UTC로 되어 있음.
 * 시간 설정을 커스텀 해주는 역할
 */
@Configuration
public class TImeZoneConfig {
    private static final String KST = "Asia/Seoul";

    @PostConstruct
    public void init() { TimeZone.setDefault(TimeZone.getTimeZone(KST));}
}
