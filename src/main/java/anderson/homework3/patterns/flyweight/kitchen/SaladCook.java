package anderson.homework3.patterns.flyweight.kitchen;

import anderson.homework3.patterns.flyweight.kitchen.Cook;

public class SaladCook implements Cook {
    @Override
    public void cooking() {
        System.out.println("Cooking salad...");
    }
}
