package core.design.pattern.behavioral.observer;

import core.design.pattern.behavioral.observer.service.Observer;
import core.design.pattern.behavioral.observer.service.Subject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private final List<Observer> observers;

    @Getter private int temperature;
    @Getter private int humidity;
    @Getter private int pressure;
    @Getter private int wind;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    public void setMeasurements(int temperature, int humidity, int pressure, int wind) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
        notifyObservers();
    }

}
