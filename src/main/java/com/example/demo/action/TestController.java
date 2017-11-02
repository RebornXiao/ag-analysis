package com.example.demo.action;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {


    @RequestMapping(value = "/test/{itemId}", method = RequestMethod.GET)
    public String addItemToCart(@PathVariable("itemId") Long itemId) {


        return "redirect:/cart/list.html";
    }

}
