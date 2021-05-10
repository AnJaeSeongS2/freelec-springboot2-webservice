package org.sonan.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jaeseong on 2021/05/10
 * Git Hub : https://github.com/AnJaeSeongS2
 */

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/posts/create")
    public String postCreate() {
        return "create-post";
    }
}
