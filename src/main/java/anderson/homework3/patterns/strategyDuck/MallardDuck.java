package anderson.homework3.patterns.strategyDuck;

import anderson.homework3.patterns.strategyDuck.fly.FlyWithWings;
import anderson.homework3.patterns.strategyDuck.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("I'm a mallard Duck");
    }
}
