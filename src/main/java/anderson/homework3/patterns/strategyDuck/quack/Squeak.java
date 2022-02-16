package anderson.homework3.patterns.strategyDuck.quack;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Пиии-Пиии");
    }
}
