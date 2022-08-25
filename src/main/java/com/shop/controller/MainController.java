package com.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping(value = "/")
    public String main(){
        return "main";
    }

<<<<<<< HEAD
    @GetMapping(value = "/community")
    public String write(){
        return "communityWrite";
    }

    @GetMapping(value = "/profile")
    public String profile(){
        return "Profile";
    }

    @GetMapping(value = "/communityList1")
    public String list(){
        return "community/list1";
    }

    @GetMapping(value = "/communityList2")
    public String list2(){
        return "community/list2";
    }

    @GetMapping(value = "/communityList3")
    public String list3(){
        return "community/list3";
    }

=======
    @GetMapping("/community")
    public String communityWrite() {
        return "communityWrite";
    }

>>>>>>> adcdb7cf51f8c65b77e162c18c34cfdb483386d6
}