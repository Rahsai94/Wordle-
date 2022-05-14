package controller;

import gui.wordlePanels.WordleLetter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelKeyboardListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(WordleLetter.getColumn() <= 4 && WordleLetter.getColumn() != -1 && WordleLetter.getRow() != -1){
            WordleLetter.getWords()[WordleLetter.getRow()][WordleLetter.getColumn()].setText(button.getText());
            WordleLetter.addColumn();
        }
    }
}
