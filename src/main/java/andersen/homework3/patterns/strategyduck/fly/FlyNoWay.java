package andersen.homework3.patterns.strategyduck.fly;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly :`( ");
    }
}
