package ro.fasttrackit.convertor;

import java.text.DecimalFormat;

public class TemperatureConversion {

    public double fahrenheitToCelsius(double temperature) {
        double result = (temperature - 32) * 5 / 9;
        if (result >= Double.MAX_VALUE || result <= Double.MIN_VALUE) {
            throw new IllegalArgumentException();
        } else {
            return formatWithTwoDecimals(result);
        }
    }

    public double celsiusToFahrenheit(double temperature) {
        double result = (temperature * 9 / 5) + 32;
        if (result >= Double.MAX_VALUE || result <= Double.MIN_VALUE) {
            throw new IllegalArgumentException();
        }else{
            return formatWithTwoDecimals(result);
        }
    }

    public double formatWithTwoDecimals(double temperature) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(temperature));
    }
}
