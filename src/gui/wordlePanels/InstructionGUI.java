package gui.wordlePanels;

import gui.wordleBox.InstructionBox;
import gui.wordleBox.LetterTextField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class InstructionGUI extends JFrame{

    private JFrame instructionFrame = new JFrame();

    public InstructionGUI() throws IOException {
        instructionFrame.setSize(new Dimension(500, 530));
        instructionFrame.setResizable(false);
        instructionFrame.setBackground(Color.WHITE);
        instructionFrame.setLayout(null);
        instructionFrame.add(new InstructionBox());
        instructionFrame.setVisible(true);
    }
}
