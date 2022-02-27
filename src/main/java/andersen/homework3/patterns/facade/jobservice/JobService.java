package andersen.homework3.patterns.facade.jobservice;

public class JobService {
    public void repairEngine(){
        System.out.println("The master performs engine repair...");
    }

    public  void repairHeadlights(){
        System.out.println("The master adjusts the headlights...");
    }

    public void oilCChange(){
        System.out.println("The master change of oil...");
    }
}
