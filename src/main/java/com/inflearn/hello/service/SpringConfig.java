package com.inflearn.hello.service;

import com.inflearn.hello.repository.MemberRepository;
import com.inflearn.hello.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public  MemberService memberService(){
        return  new MemberService(memberRepository());
        //생성자에 뭘 넣어줘야하나?
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
