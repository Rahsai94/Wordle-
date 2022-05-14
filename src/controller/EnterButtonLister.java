package controller;

import gui.wordleBox.ScoreBox;
import gui.wordlePanels.WordleLetter;
import wordle.Score;
import wordle.Wordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class EnterButtonLister implements ActionListener {

    private final Color GREENCOLOR = new Color(106,170,100);
    private final Color YELLOWCOLOR = new Color(201, 180,88);
    private final Color GREYCOLOR = new Color(120, 124,126);


    private static Score[] scores = new Score[6];

    @Override
    public void actionPerformed(ActionEvent e) {

        int row = WordleLetter.getRow();
        String inputString = "";

            for (int i = 0; i < 5; i++) {
               inputString += WordleLetter.getWords()[row][i].getText();
            }
            inputString = inputString.toLowerCase();

            if(inputString.length() != 5 ){
                System.out.println("Not completed string "+inputString);
            }
            else {

                int[] result = Wordle.checkWordle(inputString);

                if(result[0] == 6){

                    Score.WIN = true;

                    if(Score.scores.get(WordleLetter.getRow()) == null){
                        Score.scores.put(WordleLetter.getRow(), 1);
                    }else {
                        Score.scores.put(WordleLetter.getRow(), Score.scores.get(WordleLetter.getRow())+1);
                    }

                    for (int i = 0; i < result.length; i++) {
                        WordleLetter.getWords()[row][i].setBackground(GREENCOLOR);
                    }
                    String[] options = {"Yes", "No"};

                    System.out.println("Score: "+ Score.scores.get(WordleLetter.getRow()));

                    System.out.println(Score.scores.get(WordleLetter.getRow()));

                    int answer = JOptionPane.showOptionDialog(null, new ScoreBox(), "Score",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                    System.out.println("Option: "+answer);
                    if(answer == 0){

                        Score.WIN = false;

                        WordleLetter.resetColumn();
                        WordleLetter.resetRow(0);

                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 6; j++) {
                                WordleLetter.getWords()[j][i].setText("");
                                WordleLetter.getWords()[j][i].setBackground(Color.WHITE);
                            }
                        }
                        Wordle.getTarget();

                        Score.numberOfGames++;
                    }else {

                    }

                }else if(result[0] == -2){

                    System.out.println("Invalid String");

                    JOptionPane.showMessageDialog(null, "Given Word Not present In Dictionary", "Invalid Word",JOptionPane.CLOSED_OPTION);

                    for (int i = 0; i < 5; i++) {
                        WordleLetter.getWords()[row][i].setText("");
                    }

                    WordleLetter.resetColumn();

                    //JOptionPane.showMessageDialog(null, new InstructionBox(),"Invalid String",JOptionPane.ERROR_MESSAGE,new ImageIcon("images/gwhite.gif"));
                }else{
                    for (int i = 0; i < result.length; i++) {
                        if(result[i] == 1){
                            WordleLetter.getWords()[row][i].setBackground(GREENCOLOR);
                        } else if (result[i] == 2) {
                            WordleLetter.getWords()[row][i].setBackground(YELLOWCOLOR);
                        }else{
                            WordleLetter.getWords()[row][i].setBackground(GREYCOLOR);
                        }
                    }

                    if(WordleLetter.getRow() == 5){

                        Score.WIN = false;

                        String[] options = {"Yes", "No"};
                        int answer = JOptionPane.showOptionDialog(null, new ScoreBox(), "Score",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                        System.out.println("Option: "+answer);
                        if(answer == 0){

                            Score.WIN = false;
                            WordleLetter.resetColumn();
                            WordleLetter.resetRow(-1);

                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 6; j++) {
                                    WordleLetter.getWords()[j][i].setText("");
                                    WordleLetter.getWords()[j][i].setBackground(Color.WHITE);
                                }
                            }
                            Wordle.getTarget();
                            Score.numberOfGames++;
                        }else {

                        }

                    }else {
                        System.out.println(WordleLetter.getRow());
                        WordleLetter.resetColumn();
                    }

                    if(WordleLetter.getRow() < 5){
                        WordleLetter.addRow();
                    }
                }


            }

    }
}
