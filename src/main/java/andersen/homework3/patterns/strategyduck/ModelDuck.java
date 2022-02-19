package andersen.homework3.patterns.strategyduck;

import andersen.homework3.patterns.strategyduck.fly.FlyNoWay;
import andersen.homework3.patterns.strategyduck.quack.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("I'm a model duck");
    }
}
