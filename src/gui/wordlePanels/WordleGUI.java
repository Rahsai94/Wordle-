package gui.wordlePanels;

import gui.wordleBox.InstructionBox;
import gui.wordleBox.ScoreBox;
import wordle.Score;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WordleGUI  extends JFrame{
    public  JFrame wordleScreen = new JFrame();
    private static WordleLetter words = new WordleLetter();

    private static WordleKeybord keyborad = new WordleKeybord();

    public WordleGUI() throws IOException {
        wordleScreen.setMinimumSize(new Dimension(700, 700));
        wordleScreen.setBackground(Color.WHITE);
        wordleScreen.setLayout(null);
        wordleScreen.add(keyborad);
        wordleScreen.add(words);
        wordleScreen.setVisible(true);
        wordleScreen.setResizable(false);
        wordleScreen.setLocationRelativeTo(null);
        if(Score.getINITIALISE() == 0){
            JOptionPane.showMessageDialog(null, new InstructionBox(), "Instructions",JOptionPane.CLOSED_OPTION);
            //JOptionPane.showMessageDialog(null, new ScoreBox(), "Instructions",JOptionPane.CLOSED_OPTION);
        }else {
            Score.setINITIALISE(1);
        }
    }

    public static WordleLetter getWords(){
        return words;
    }
}
