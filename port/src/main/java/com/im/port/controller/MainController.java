package com.im.port.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
    
    @GetMapping({ "", "/" })
    public String index() {
        System.out.println("===================메인컨트롤러 index.html=============");
        // 머스테치 기본폴더 src/main/resources/
        // 뷰리졸버 설정 : templates (prefix), .mustache (suffix) 생략가능
        return "index"; // src/main/resources/templates/index.mustache
    }
    
    @ResponseBody
    @GetMapping("/loginSuccess")
    public String loginSuccess(){
        System.out.println("===================메인컨트롤러 로그인 성공=============");
        return "로그인 성공";
    }

}
