package controller;

import java.util.*;

public class GenerateWord {

    //use this method for selecting a word. It's important for marking that the word you have selected is printed out to the console!
    public static String getTarget(List<String> targetWords){
        Random r = new Random();
        String target = targetWords.get(r.nextInt(targetWords.size()));
        //don't delete this line.
        System.out.println(target);
        return target;
    }

}