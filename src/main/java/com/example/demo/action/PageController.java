package com.example.demo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("list")
    public String list(){
        return  "list";
    }

    @RequestMapping("page")
    public String page(){
        return  "page";
    }

    @RequestMapping("detail")
    public String detail(){
        return  "detail";
    }

    @RequestMapping("all")
    public String all(){
        return  "main/all";
    }
    @RequestMapping("main")
    public String main(){
        return  "main/main";
    }
}
