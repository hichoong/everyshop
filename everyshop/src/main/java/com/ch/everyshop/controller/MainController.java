package com.ch.everyshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/every")
    @ResponseBody
    public String index() {
        return "EveryShop에 오신것을 환영합니다!!!";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }


}
