package controller;

import gui.wordleBox.LetterTextField;
import gui.wordlePanels.WordleLetter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardListener implements KeyListener {


    String prev = null;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            System.out.println("Backward Button");
        } else if (e.getKeyCode() != KeyEvent.VK_ENTER){
            // System.out.println(e.getComponent());
            if(Character.toString(e.getKeyChar()).matches("^[a-zA-Z]*$")){
                if(e.getSource().getClass().toString().equals("class gui.wordleButoons.LetterButton")){
                    if(WordleLetter.getColumn() <= 4){
                        WordleLetter.getWords()[WordleLetter.getRow()][WordleLetter.getColumn()].setText((e.getKeyChar()+"").toUpperCase());
                        WordleLetter.addColumn();
                    }
                }else if(e.getSource().getClass().toString().equals("class gui.wordleBox.LetterTextField")){
                    LetterTextField textField = (LetterTextField) e.getSource();
                        if(WordleLetter.getRow() == textField.getRow()){
                            textField.setText((""+e.getKeyChar()).toUpperCase());
                            e.getComponent().transferFocus();
                            WordleLetter.addColumn();
                        }
                }
            }
        }
    }
}
