package anderson.homework3.patterns.strategyduck.quack;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Кря-кря");
    }
}
