package andersen.homework3.patterns.facade.jobservice;

public class SparePart {
    public boolean sparePart;

    public boolean isSparePart(){
        return sparePart;
    }
    public void haveSparePart(){
        System.out.println("Service is have SparePart... ");
        sparePart = true;
    }

    public void notSparePart(){
        System.out.println("Service don't have SparePart... ");
        sparePart = false;
    }
}
