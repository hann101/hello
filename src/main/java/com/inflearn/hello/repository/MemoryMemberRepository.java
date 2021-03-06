package com.inflearn.hello.repository;

import com.inflearn.hello.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private  static Map<Long,Member> store = new HashMap<>();
    private  static  long sequence= 0L; //동시성 문제가 있음.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
//        return Optional.empty();
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
