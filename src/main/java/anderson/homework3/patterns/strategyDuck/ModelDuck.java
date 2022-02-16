package anderson.homework3.patterns.strategyDuck;

import anderson.homework3.patterns.strategyDuck.fly.FlyNoWay;
import anderson.homework3.patterns.strategyDuck.quack.Quack;

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
