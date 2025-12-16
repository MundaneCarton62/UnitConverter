package com.example.UnitConverter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UnitConverterController {
    private final UnitConverterService service;


    public UnitConverterController(UnitConverterService service) {
        this.service = service;
    }



    @GetMapping("/")
    public String home(){
        return "home.html";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam double value, Model model){
        double result = service.celsiusesFahrenheit(value);
        model.addAttribute("result",result);
        return "home";
    }
}
