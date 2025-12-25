package com.example.UnitConverter;

import org.springframework.stereotype.Service;

@Service
public class UnitConverterService {

    public double convertTemperature(double value, TemperatureUnit from, TemperatureUnit to) {
        if(from==to){
            return value;
        }
        switch (from){
            case CELSIUS -> {
                return to == TemperatureUnit.FAHRENHEIT
                        ? (value * 9 / 5) + 32
                        : value + 273.15;
            }
            case FAHRENHEIT -> {
                return to == TemperatureUnit.CELSIUS
                        ? (value - 32) * 5 / 9
                        : (value - 32) * 5 / 9 + 273.15;
            }
            case KELVIN -> {
                return to == TemperatureUnit.CELSIUS
                        ? value - 273.15
                        : (value - 273.15) * 9 / 5 + 32;
            }
            default ->  throw new IllegalArgumentException("Unsupported Conversion");
        }
    }

    public double convertLength(double value, LengthUnit from, LengthUnit to) {

        double meters = 0;

        switch (from){
            case MILLIMETER -> meters = value / 1000;
            case CENTIMETER ->meters = value / 100;
            case METER -> meters = value;
            case KILOMETER -> meters = value * 1000;
        }

        return switch (to) {
            case MILLIMETER -> meters * 1000;
            case CENTIMETER -> meters * 100;
            case METER -> meters;
            case KILOMETER -> meters / 1000;
        };

    }

    public double convertWeight(double value, WeightUnit from, WeightUnit to) {
        double gram = 0;

        switch (from){
            case MILLIGRAM -> gram = value / 1000;
            case GRAM ->gram = value;
            case KILOGRAM -> gram = value * 1000;
            case OUNCE -> gram = value * 28.3495;
            case POUND -> gram = value * 453.592;
        }

        return switch (to) {
            case MILLIGRAM -> gram* 1000;
            case GRAM -> gram;
            case KILOGRAM -> gram / 1000;
            case OUNCE -> gram / 28.3495;
            case POUND -> gram / 453.592;
        };
    }
}
