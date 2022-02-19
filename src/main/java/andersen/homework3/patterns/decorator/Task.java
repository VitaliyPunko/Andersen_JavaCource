package andersen.homework3.patterns.decorator;

public class Task {
    public static void main(String[] args) {
        Developer developer = new JavaTeamLead(new SeniorJavaDeveloper(new MidlJavaDeveloper((new JavaDeveloper()))));

        System.out.println(developer.makeJob());
    }
}
