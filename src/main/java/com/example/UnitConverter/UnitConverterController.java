package com.example.UnitConverter;

import jakarta.validation.constraints.DecimalMin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.Math.round;


@Controller
@Validated
@SuppressWarnings("unused")
public class UnitConverterController {
    private final UnitConverterService service;


    public UnitConverterController(UnitConverterService service) {
        this.service = service;
    }



    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("type", ConversionType.TEMPERATURE);
        model.addAttribute("from", "CELSIUS");
        model.addAttribute("to", "FAHRENHEIT");
        model.addAttribute("value", 0);
        return "home.html";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam @DecimalMin("0.0") double value,
                          @RequestParam ConversionType type,
                          @RequestParam String from,
                          @RequestParam String to,
                          Model model){
        double result = 0;
        if(type == ConversionType.TEMPERATURE) {
            result = service.convertTemperature(
                    value, TemperatureUnit.valueOf(from),
                    TemperatureUnit.valueOf(to));
        } else if(type == ConversionType.LENGTH) {
            result = round(
                    service.convertLength(
                            value,
                            LengthUnit.valueOf(from),
                            LengthUnit.valueOf(to)));
        } else if (type == ConversionType.WEIGHT){
            result = round(
                    service.convertWeight(
                            value,
                            WeightUnit.valueOf(from),
                            WeightUnit.valueOf(to)));
        }
        model.addAttribute("type",type);
        model.addAttribute("result",result);
        model.addAttribute("value", value);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        return "home";
    }
}
