package com.inflearn.hello.service;


import com.inflearn.hello.domain.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


class MemberServiceTest {
    MemberService memberService = new MemberService();


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void findMembers() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring2");

        //when
        memberService.join(member1);
        try{
            memberService.join(member2);
            fail("실패");
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123123");
        }

        //then
    }

    @Test
    void findOne() {
    }
}