package andersen.homework3.patterns.flyweight.kitchen;

import java.util.HashMap;
import java.util.Map;

public class Kitchen {
    private static final Map<String, Cook> cooks = new HashMap<>();

    public Cook getCookBySpeciality(String speciality){
        Cook cook = cooks.get(speciality);

        if (cook == null){
            switch (speciality){
                case "pizza":
                    System.out.println("Pizza order\n");
                    cook = new PizzaCook();
                    break;
                case "salad":
                    System.out.println("Salad order\n");
                    cook = new SaladCook();
                    break;
            }
            cooks.put(speciality, cook);
        }
        return cook;
    }
}
