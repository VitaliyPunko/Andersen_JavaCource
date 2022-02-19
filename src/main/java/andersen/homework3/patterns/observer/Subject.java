package andersen.homework3.patterns.observer;

import andersen.homework3.patterns.observer.observers.Observer;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();


}
