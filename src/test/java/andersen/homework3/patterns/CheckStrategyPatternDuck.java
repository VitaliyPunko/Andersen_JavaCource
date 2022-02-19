package andersen.homework3.patterns;

import andersen.homework3.patterns.strategyduck.Duck;
import andersen.homework3.patterns.strategyduck.MallardDuck;
import andersen.homework3.patterns.strategyduck.quack.MuteQuack;
import andersen.homework3.patterns.strategyduck.quack.Squeak;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestCheckStrategyPatternDuck {

    @Test
    void shouldReturnCorrectDuckAbilities() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        Assertions.assertEquals("Кря-кря", mallard.performQuack());

        mallard.setQuackBehavior(new Squeak());
        Assertions.assertEquals("Пиии-Пиии", mallard.performQuack());

        mallard.setQuackBehavior(new MuteQuack());
        Assertions.assertEquals("<<Silence>>", mallard.performQuack());
    }
}
