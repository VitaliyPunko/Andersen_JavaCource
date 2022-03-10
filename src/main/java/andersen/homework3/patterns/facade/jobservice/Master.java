package andersen.homework3.patterns.facade.jobservice;


public class Master {
    public void doJobMaster(SparePart sparePart){
        if (sparePart.isSparePart()){
            System.out.println("Car is repair");
        }else {
            System.out.println("Master is out of work..");
        }
    }
}
