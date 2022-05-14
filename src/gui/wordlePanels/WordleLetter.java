package gui.wordlePanels;

import gui.wordleBox.LetterTextField;

import javax.swing.*;
import java.awt.*;

public class WordleLetter extends JPanel {

    private static int column = 0;
    private static int row = 0;

    private static final LetterTextField[][] words = new LetterTextField[6][5];

    public WordleLetter(){
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                words[i][j] = new LetterTextField(j, i);
            }
        }

        setBounds(170,50,300,300);
        setLayout(new GridLayout(6, 5));

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                add(words[i][j]);
            }
        }
    }

    public static int getColumn(){
        return column;
    }

    public static void addColumn(){
        column += 1;
    }

    public static void resetColumn(){
        column = 0;
    }

    public static int getRow(){
        return  row;
    }

    public static void addRow(){
        row++;
    }

    public static void resetRow(int c){
        row = c;
    }

    public static void removeColumn(){
        column--;
    }

    public static LetterTextField[][] getWords(){
        return words;
    }



}
