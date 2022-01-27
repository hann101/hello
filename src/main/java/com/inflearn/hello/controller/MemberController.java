package com.inflearn.hello.controller;


import com.inflearn.hello.domain.Member;
import com.inflearn.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
        //view로 보내주고 렌더링
        //form (데이터 입력가능)
        //input을 통해 데이터를 전달. name=  이 데이터를 넘겨줄때의 key가 된다.
        //input을 누르면 post형식으로 데이터를 보내준다.
        //아래의 post실행됨..그안의 create실행하기됨.
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        //get에서 받으 ㄴname 변수를 통해 form에 name 이 전달하게됨.
        //form이라는 객체에 name="spring1"이라는 녀석을 담고 있고
        Member member = new Member();
        member.setName(form.getName());
        //form.getName으로 name="spring1"이라는 녀석을 불러
        //setName으로 멤버 객체에 저장

        memberService.join(member);
        //서비스를 join의 save 통해 저장을 하게됨.
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/membersList";
    }



}
