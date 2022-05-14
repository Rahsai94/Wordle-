package controller;

import gui.wordlePanels.WordleLetter;
import wordle.Score;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if(WordleLetter.getColumn() > 0 && !(Score.WIN)){
            WordleLetter.getWords()[WordleLetter.getRow()][WordleLetter.getColumn()-1].setText("");
            WordleLetter.removeColumn();
        }

    }

}
