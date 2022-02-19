package andersen.homework3.patterns.strategyduck;

import andersen.homework3.patterns.strategyduck.fly.FlyBehavior;
import andersen.homework3.patterns.strategyduck.quack.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public String performQuack() {
        return quackBehavior.quack();
    }

    public void performFly() {
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
