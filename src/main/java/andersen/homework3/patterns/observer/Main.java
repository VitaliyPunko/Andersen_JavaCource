package andersen.homework3.patterns.observer;

import andersen.homework3.patterns.observer.observers.CurrentHumidityDisplay;
import andersen.homework3.patterns.observer.observers.CurrentPressureDisplay;
import andersen.homework3.patterns.observer.observers.CurrentTempDisplay;
import andersen.homework3.patterns.observer.observers.Observer;

public class Main {

    public static void main(String[] args) {
        WeatherData subject = new WeatherData();
        Observer tempObserver = new CurrentTempDisplay(subject);
        Observer pressureObserver = new CurrentPressureDisplay(subject);
        Observer humidityObserver = new CurrentHumidityDisplay(subject);

        subject.setMeasurement(1f, 2f, 3f);
        subject.removeObserver(tempObserver);
        subject.setMeasurement(4f, 5f, 6f);
        subject.removeObserver(pressureObserver);
        subject.setMeasurement(7f, 8f, 9f);
        subject.registerObserver(humidityObserver);
    }

}
