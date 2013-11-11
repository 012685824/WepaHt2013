package wad.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.template.domain.Books;

@Controller
public class DefaultController {
    
    @RequestMapping("*")
    public String handleDefault() {
        return "menu";
    }

}
