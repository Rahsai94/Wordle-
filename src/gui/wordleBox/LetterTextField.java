package gui.wordleBox;

import controller.KeyboardListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class LetterTextField extends JTextField {
    private final int position;
    private final int row;
    public LetterTextField(int position, int row){
        this.position = position;
        this.row = row;
        setBackground(Color.WHITE);
        setEditable(false);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(238,238,238), 5), BorderFactory.createEmptyBorder(5,15,5,0)
        ));
        setFont(new Font("Serif", Font.BOLD, 20));

        addKeyListener(new KeyboardListener());
    }

    public int getRow(){return this.row;}



    public int getPosition(){ return this.position; }
}
