package ro.fasttrackit.convertor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConversionTest {
    private TemperatureConversion tempConv;
    @BeforeEach
    void setup(){
        System.out.println("---SETUP---");
         tempConv = new TemperatureConversion();
    }

    @Test
    @DisplayName("WHEN we convert 0 fahrenheit to celsius THEN the result must be -17.78 fahrenheit")
    void convert0CtoFahrenheit() {

        //RUN
        var result = tempConv.fahrenheitToCelsius(0);
        //ASSERT
        Assertions.assertThat(result).isEqualTo(-17.78);
    }

    @Test
    @DisplayName("WHEN we convert 0 celsius to fahrenheit THEN the result must be 32 fahrenheit")
    void convert0FtoCelsius(){
        //RUN
        var result = tempConv.celsiusToFahrenheit(0);
        //ASSERT
        Assertions.assertThat(result).isEqualTo(32);
    }
    @Test
    @DisplayName("WHEN converting a negative number to Celsius THEN return correct answer")
    void convertNegativeFahrenheitToCelsius(){
        var result = tempConv.fahrenheitToCelsius(-14);
        Assertions.assertThat(result).isEqualTo(-25.56);
    }

    @Test
    @DisplayName("WHEN converting a negativ number to Fahrenheit THEN return correct answer ")
    void convertNegativeCelsiusToFahrenheit(){
        var result = tempConv.celsiusToFahrenheit(-14);
        Assertions.assertThat(result).isEqualTo(6.8);
    }

    @Test
    @DisplayName("When converting max Double Celsius value to Fahrenheit THEN throw Exception")
    void convertMaxDoubleValueToFahrenheit(){
        assertThrows(IllegalArgumentException.class, () -> tempConv.celsiusToFahrenheit(Double.MAX_VALUE));

    }
    @Test
    @DisplayName("When converting max Double Celsius value to Fahrenheit THEN throw Exception")
    void convertMaxDoubleValueToCelsius(){
        assertThrows(IllegalArgumentException.class, () -> tempConv.fahrenheitToCelsius(Double.MAX_VALUE));
    }

    @Test
    @DisplayName("When converting min Double Celsius value to Fahrenheit THEN throw Exception")
    void convertMinDoubleValueToCelsius(){
        assertThrows(IllegalArgumentException.class, () -> tempConv.fahrenheitToCelsius(Double.MIN_VALUE));
    }

    @Test
    @DisplayName("WHEN we write a double with more than two decimals THEN return it with just two decimals")
    void formatWithTwoDecimals() {
        var result = tempConv.formatWithTwoDecimals(17.777);
        Assertions.assertThat(result).isEqualTo(17.78);
    }
}