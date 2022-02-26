package andersen.homework3.patterns.adapter;

public class AdapterJavaToDatabase extends JavaApplication implements Database {

    @Override
    public void insert() {
        saveObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void read() {
        readObject();
    }

    @Override
    public void delete() {
        deleteObject();
    }
}
