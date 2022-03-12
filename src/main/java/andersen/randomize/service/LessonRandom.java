package andersen.randomize.service;

import andersen.randomize.dao.TeamRepository;

import java.util.Random;

public class LessonRandom {





    public static void main(String[] args) {
        LessonRandom qw = new LessonRandom();
        LessonRandom an= new LessonRandom();
        System.out.println(qw.getQuestion());
        System.out.println(an.getAnswer());
        if (qw.getQuestion()== an.getAnswer()){
            an.getAnswer();
        }
    }
    public  Integer getQuestion(){
        int a = 0;
        int b = 28;
        Random random = new Random();
        int x = 0 + random.nextInt(b-a+1);
        return x;
    }
    public  Integer getAnswer(){
        int a = 0;
        int b = 28;
        Random random = new Random();
        int x = 0 + random.nextInt(b-a+1);
        return x;
    }



}
