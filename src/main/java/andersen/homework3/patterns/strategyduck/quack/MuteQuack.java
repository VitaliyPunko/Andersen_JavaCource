package andersen.homework3.patterns.strategyduck.quack;

public class MuteQuack implements QuackBehavior {

    @Override
    public String quack() {
        return "<<Silence>>";
    }
}
