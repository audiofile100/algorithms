package core.design.pattern.behavioral.observer;

import core.design.pattern.behavioral.observer.service.Observer;
import lombok.Getter;

public class SimpleCurrentConditions implements Observer {

    private final WeatherData weatherData;

    @Getter private int temperature;
    @Getter private int humidity;

    public SimpleCurrentConditions(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {

        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();

        display();
    }

    public void display() {
        System.out.println("Simple Display: " + temperature + " F degrees and " + humidity + " % humidity.");
    }
}
