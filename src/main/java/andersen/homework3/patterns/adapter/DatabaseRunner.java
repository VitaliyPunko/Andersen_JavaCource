package andersen.homework3.patterns.adapter;

/**
 * Цель - преобразование интерфейса одного класса в интерфейс того класса,
 * который необходим клиенту
 * <p>
 * Адаптер — это структурный паттерн проектирования,
 * который позволяет объектам с несовместимыми интерфейсами работать вместе.
 */
public class DatabaseRunner {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();

        database.insert();
        database.update();
        database.read();
        database.delete();
    }
}
