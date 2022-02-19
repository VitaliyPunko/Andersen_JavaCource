package andersen.homework3.patterns.strategyduck;

import andersen.homework3.patterns.strategyduck.fly.FlyWithWings;
import andersen.homework3.patterns.strategyduck.quack.Quack;

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
