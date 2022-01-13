package com.inflearn.hello.service;

import com.inflearn.hello.domain.Member;
import com.inflearn.hello.repository.MemberRepository;
import com.inflearn.hello.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private  final MemberRepository memberRepository = new MemoryMemberRepository();
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}