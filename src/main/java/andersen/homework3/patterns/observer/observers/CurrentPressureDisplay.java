package andersen.homework3.patterns.observer.observers;

import andersen.homework3.patterns.observer.Subject;
import andersen.homework3.patterns.observer.WeatherData;

public class CurrentPressureDisplay implements Observer, DisplayElements {

    private float pressure;
    private Subject weatherData;

    public CurrentPressureDisplay(Subject weatherData) {
        this.weatherData = new WeatherData();
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Pressure is: " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }
}
