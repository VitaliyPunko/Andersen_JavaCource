package anderson.homework3.patterns.strategyduck;

import anderson.homework3.patterns.strategyduck.fly.FlyBehavior;
import anderson.homework3.patterns.strategyduck.quack.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    void performQuack() {
        quackBehavior.quack();
    }

    void performFly() {
        flyBehavior.fly();
    }

    void swim() {
        System.out.println("I'm swimming");
    }

    abstract void display();

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
