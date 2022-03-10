package andersen.homework3.patterns.facade;

public class Customer {
    public static void main(String[] args) {
        Service service = new Service();

        service.jobRepair();
    }
}
