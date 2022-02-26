package andersen.homework3.patterns.factory;

/**
 * ипользуется для делегирования создания объектов другому классу
 * Фабричный метод отделяет код производства продуктов
 * от остального кода, который эти продукты использует.
 * <p>
 * Если неизвестно экземпляры какого класса будут использоваться
 */
public class Main {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperByLanguage("php");
        Developer developer = developerFactory.createDeveloper();
        System.out.println(developer.writeCode());
    }

    static DeveloperFactory createDeveloperByLanguage(String language) {
        if (language.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (language.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        } else throw new IllegalArgumentException("There isn't this language");
    }
}
