package core.design.pattern.behavioral.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverPatternTest {

    private WeatherData weatherData;

    @BeforeEach
    public void setUp() {
        this.weatherData = new WeatherData();
    }

    @Test
    public void simpleCurrentConditionsTest() {

        SimpleCurrentConditions simple = new SimpleCurrentConditions(weatherData);

        weatherData.setMeasurements(85, 29, 20, 5);

        int temperature = simple.getTemperature();
        int humidity = simple.getHumidity();

        assertEquals(85, temperature);
        assertEquals(29, humidity);
    }

    @Test
    public void advancedCurrentConditionsTest() {

        AdvancedCurrentConditions advanced = new AdvancedCurrentConditions(weatherData);

        weatherData.setMeasurements(87, 27, 22, 8);

        int temperature = advanced.getTemperature();
        int humidity = advanced.getHumidity();
        int pressure = advanced.getPressure();
        int wind = advanced.getWind();

        assertEquals(87, temperature);
        assertEquals(27, humidity);
        assertEquals(22, pressure);
        assertEquals(8, wind);
    }
}
