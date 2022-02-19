package andersen.homework3.patterns.observer.observers;

/**
 * Используем для зависимости "один ко многим"
 * Чтоб при изменении состояния одного объекта, все зависящие от него объекты
 * были оповещенны и обновились
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);
}
