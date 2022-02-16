package anderson.homework3.patterns.strategyDuck.quack;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Кря-кря");
    }
}
