package com.inflearn.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        //request로 변수 값을 받고 num으로 저장 시킨다
        model.addAttribute("name",name);
        //위의 내용을 받아서 model로 전달 -> hello-mvc의 num과 연결시킨다,
        return  "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    //HTTPMessageConvert가 문자를 받으면
    //StringHTTPMessageConvert가
    //아! 그대로 돌려줘야겠구나!라고 판단함
    public  String helloString(@RequestParam("name") String name){
        return  "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    //HTTPMessageConverter가 받아..
    //객체가 오면 ??
    // MappingJackson2HttpMessageConvert는 JSON으로 돌려줘야겠다!라고 판단함
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }



    static class  Hello{

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
