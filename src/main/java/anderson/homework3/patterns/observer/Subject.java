package anderson.homework3.patterns.observer;

import anderson.homework3.patterns.observer.observers.Observer;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();


}
