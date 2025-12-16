package com.example.UnitConverter;

import org.springframework.stereotype.Service;

@Service
public class UnitConverterService {

    public double celsiusesFahrenheit(double celsius){
        return (celsius * 9/5) + 32;
    }
}
