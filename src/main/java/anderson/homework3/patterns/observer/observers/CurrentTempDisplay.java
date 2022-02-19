package anderson.homework3.patterns.observer.observers;

import anderson.homework3.patterns.observer.Subject;

public class CurrentTempDisplay implements Observer, DisplayElements {

    private float temperature;
    private Subject weatherData;

    public CurrentTempDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        display();
    }

    @Override
    public void display() {
        System.out.println("Temperature is: " + temperature);
    }
}
