package com.inflearn.hello.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.inflearn.hello.domain.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
//    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member,result);
//        Assertions.assertThat(member).isEqualTo(null);

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        //member 객체 연결
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //Case
        Member result = repository.findByName("spring1").get();
//        MemoryMemberRepository repository 의 findByName 메소드로 spring2를 가져온다.
//        그리고 Member 객체의 result에 담아
        Assertions.assertThat(result).isEqualTo(member1);
//        result와 member1값이 같은지 체크 한다.


    }

    @Test
    public void findByAll(){
        Member member1 = new Member();
        //member 객체 연결
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //테스트는 순서에 상관없이 지맘대로 돌아
        //그래서 이전에 지정한 객체들이 그대로 남아서 ㅇ에러가 뜸
        //everyeach를 지정해준다.

        List<Member> result = repository.findAll();
        //repository에서 findall해온 값을 List<Member> 객체의 result에 담는다.
        Assertions.assertThat(result.size()).isEqualTo(3);


    }


}
