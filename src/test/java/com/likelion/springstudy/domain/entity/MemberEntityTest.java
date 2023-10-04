//package com.likelion.springstudy.domain.entity;
//
//import com.likelion.springstudy.repository.MemberJpaRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//public class MemberEntityTest {
//    @Autowired
//    MemberJpaRepository memberRepository;
//
//    @Test
//    public void testMember() {
//        // given
//        Member member = Member.builder()
//                .id(1L)
//                .name("byeonglock")
//                .password("1234")
//                .nickname("rokbyeong")
//                .build();
//        // when
//        memberRepository.save(member);
//        MemberEntity findMember = memberRepository.findById(1L).get();
//
//        // then
//        assertThat(findMember.getId()).isEqualTo(member.getId());
//    }
//}
