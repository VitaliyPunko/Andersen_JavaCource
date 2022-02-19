package andersen.homework3.patterns.decorator;

public class MidlJavaDeveloper extends DeveloperDecorator {

    public MidlJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String createCod(){
        return "Creates classes and entities. ";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + createCod();
    }
}
