package core.design.pattern.behavioral.observer;

import core.design.pattern.behavioral.observer.service.Observer;
import lombok.Getter;

public class AdvancedCurrentConditions implements Observer {

    private final WeatherData weatherData;

    @Getter private int temperature;
    @Getter private int humidity;
    @Getter private int pressure;
    @Getter private int wind;

    public AdvancedCurrentConditions(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
        this.wind = weatherData.getWind();

        display();
    }

    public void display() {
        System.out.println("Advanced Display: " + temperature + " F degrees and " + humidity + " % humidity.");
        System.out.println("Pressure is " + pressure + ".");
        System.out.println("And, wind gusts up to " + wind + " mph.");
    }
}
