package anderson.homework3.patterns.facade;

import anderson.homework3.patterns.facade.jobservice.JobService;
import anderson.homework3.patterns.facade.jobservice.Master;
import anderson.homework3.patterns.facade.jobservice.OpenService;
import anderson.homework3.patterns.facade.jobservice.SparePart;

public class Service {
    OpenService openService = new OpenService();
    Master master = new Master();
    SparePart sparePart = new SparePart();
    JobService jobService = new JobService();

    public void jobRepair(){
        openService.openService();
        sparePart.haveSparePart();
        master.doJobMaster(sparePart);
        jobService.repairEngine();
    }

}
