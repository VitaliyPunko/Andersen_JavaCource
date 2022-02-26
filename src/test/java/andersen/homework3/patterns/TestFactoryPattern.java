package andersen.homework3.patterns;

import andersen.homework3.patterns.factory.CppDeveloperFactory;
import andersen.homework3.patterns.factory.Developer;
import andersen.homework3.patterns.factory.DeveloperFactory;
import andersen.homework3.patterns.factory.JavaDeveloperFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestFactoryPattern {

    @Test
    void shouldCreateJavaDeveloper() {
        DeveloperFactory factory = new JavaDeveloperFactory();
        Developer developer = factory.createDeveloper();
        Assertions.assertEquals("Java developer writes java code...", developer.writeCode());
    }

    @Test
    void shouldCreateCppDeveloper() {
        DeveloperFactory factory = new CppDeveloperFactory();
        Developer developer = factory.createDeveloper();
        Assertions.assertEquals("C++ developer writes c++ code...", developer.writeCode());
    }
}
