package andersen.homework3.patterns.observer.observers;

import andersen.homework3.patterns.observer.Subject;
import andersen.homework3.patterns.observer.WeatherData;

public class CurrentHumidityDisplay implements Observer, DisplayElements {

    private float humidity;
    private Subject weatherData;

    public CurrentHumidityDisplay(Subject weatherData) {
        this.weatherData = new WeatherData();
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Humidity is: " + humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.humidity = humidity;
        display();
    }
}
