package gui.wordlePanels;

import controller.DeleteButtonListener;
import controller.EnterButtonLister;
import controller.PanelKeyboardListener;
import controller.KeyboardListener;
import gui.wordleButoons.DeleteButton;
import gui.wordleButoons.EnterButton;
import gui.wordleButoons.LetterButton;

import javax.swing.*;

public class WordleKeybord extends JPanel {

    private final LetterButton[] buttons = {
            new LetterButton("Q", 0, 0),
            new LetterButton("W", 55, 0),
            new LetterButton("E", 110, 0),
            new LetterButton("R", 165, 0),
            new LetterButton("T", 220, 0),
            new LetterButton("Y", 275, 0),
            new LetterButton("U", 330, 0),
            new LetterButton("I", 385, 0),
            new LetterButton("O", 440, 0),
            new LetterButton("P", 495, 0),

            new LetterButton("A", 25, 65),
            new LetterButton("S", 80, 65),
            new LetterButton("D", 135, 65),
            new LetterButton("F", 190, 65),
            new LetterButton("G", 245, 65),
            new LetterButton("H", 300, 65),
            new LetterButton("J", 355, 65),
            new LetterButton("K", 410, 65),
            new LetterButton("L", 465, 65),


            new LetterButton("Z", 90, 130),
            new LetterButton("X", 145, 130),
            new LetterButton("C", 200, 130),
            new LetterButton("V", 255, 130),
            new LetterButton("B", 310, 130),
            new LetterButton("N", 365, 130),
            new LetterButton("M", 420, 130)



    };
    private final EnterButton enter = new EnterButton("Enter", 0, 130);
    private final DeleteButton delete = new DeleteButton("Delete", 475, 130);

    WordleKeybord(){
        super(null);
        setBounds(80,450,545,185);
        for (LetterButton a : buttons) {
            a.addActionListener(new PanelKeyboardListener());
            a.addKeyListener(new KeyboardListener());
            add(a);
        }
        delete.addActionListener(new DeleteButtonListener());
        enter.addActionListener(new EnterButtonLister());
        add(enter);
        add(delete);
    }

    public LetterButton[] getButtons() {
        return buttons;
    }

    public DeleteButton getDeleteButton() {
        return delete;
    }

    public EnterButton getEnterButton() {
        return enter;
    }
}
