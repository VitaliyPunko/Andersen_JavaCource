package anderson.homework3.patterns.strategyduck.quack;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("I can't quack");
    }
}
