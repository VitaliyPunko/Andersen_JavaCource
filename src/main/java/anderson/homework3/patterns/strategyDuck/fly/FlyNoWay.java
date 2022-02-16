package anderson.homework3.patterns.strategyDuck.fly;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly :`( ");
    }
}
