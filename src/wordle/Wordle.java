package wordle;

import gui.wordlePanels.WordleGUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Wordle {


    //INSTRUCTION
    private static final String winningMessage = "CONGRATULATIONS! YOU WON! :)";
    private static final String losingMessage = "YOU LOST :( THE WORD CHOSEN BY THE GAME IS: ";



    private static String targetWord;
    private static HashSet<String> dic;

    private static ArrayList<String> targetWords;

    public Wordle(String target_Word, HashSet<String> dictionary, ArrayList<String> tar) throws IOException {
        targetWord = target_Word;
        dic = dictionary;
        targetWords = tar;
        new WordleGUI();
    }

    public static int[]  checkWordle(String inputString){

        int[] result = {-1,-1,-1,-1,-1};

        String userInputWord = inputString;
        String chosenWord = targetWord;

        if(!dic.contains(inputString)){
            System.out.println("Giver word is not in dictionary");
            result[0] = -2;
            return result;
        }else if(targetWord.equals(inputString)){
            System.out.println("Result: "+winningMessage);
            result[0] = 6;
            return result;
        }else{


            //Check for Green Color POSITIOn
            for (int i = 0; i < 5; i++) {
                if(targetWord.charAt(i) == inputString.charAt(i)){
                    userInputWord = replaceChar(userInputWord, '0', i);
                    chosenWord = replaceChar(chosenWord, '0', i);
                    result[i] = 1;
                }
            }

            //Check Yellow nd grey
            for (int i = 0; i < targetWord.length(); i++){
                if (userInputWord.charAt(i) == '0') {}else
                    if(chosenWord.indexOf(userInputWord.charAt(i)) != -1){
                    result[i] = 2;
                    chosenWord = replaceChar(chosenWord, '0', chosenWord.indexOf(userInputWord.charAt(i)));
                    userInputWord = replaceChar(userInputWord, '0', i);
                    }else{
                        result[i] = 3;
                    }

            }

        }

        return result;

    }



    // method that replaces a char in a string at a specific index
    private static String replaceChar(String str, char ch, int index) {
        char[] chars = str.toCharArray();
        chars[index] = ch;
        return String.valueOf(chars);
    }


    //use this method for selecting a word. It's important for marking that the word you have selected is printed out to the console!
    public static void getTarget(){
        Random r = new Random();
        String target = targetWords.get(r.nextInt(targetWords.size()));
        //don't delete this l
        System.out.println(target);
        targetWord = target;
    }

}


