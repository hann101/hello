package com.inflearn.hello.service;

import com.inflearn.hello.repository.JdbcMemberRepository;
import com.inflearn.hello.repository.MemberRepository;
import com.inflearn.hello.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
 return new MemoryMemberRepository();
 //return new JdbcMemberRepository(dataSource);
    }
}