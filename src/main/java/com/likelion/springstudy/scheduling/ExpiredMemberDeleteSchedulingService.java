package com.likelion.springstudy.scheduling;

import com.likelion.springstudy.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Batch vs Scheduling
 */

// Service를 붙였지만 @Component 붙여도 됨.
@Service
@RequiredArgsConstructor
public class ExpiredMemberDeleteSchedulingService {
    private final MemberJpaRepository memberJpaRepository;

    @Scheduled(cron = "0 0 0 * * *") // cron expression : 시간 설정  "0 0 0 * * *" - 자정이 됐을 때 삭제
    public void deleteExpiredMember() {
        memberJpaRepository.deleteExpiredMember();
    }
}
