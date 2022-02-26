package anderson.homework3.patterns.flyweight;

import anderson.homework3.patterns.flyweight.kitchen.Cook;
import anderson.homework3.patterns.flyweight.kitchen.Kitchen;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        List<Cook> cookList = new ArrayList<>();

        cookList.add(kitchen.getCookBySpeciality("pizza"));
        cookList.add(kitchen.getCookBySpeciality("pizza"));
        cookList.add(kitchen.getCookBySpeciality("pizza"));
        cookList.add(kitchen.getCookBySpeciality("pizza"));
        cookList.add(kitchen.getCookBySpeciality("pizza"));
        cookList.add(kitchen.getCookBySpeciality("salad"));
        cookList.add(kitchen.getCookBySpeciality("salad"));
        cookList.add(kitchen.getCookBySpeciality("salad"));
        cookList.add(kitchen.getCookBySpeciality("salad"));
        cookList.add(kitchen.getCookBySpeciality("salad"));
        cookList.add(kitchen.getCookBySpeciality("salad"));

        for (Cook cook: cookList){
            cook.cooking();
        }

    }
}
