package gui.wordleButoons;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LetterButton extends JButton {
    public LetterButton(String btnText, int x_pos, int y_pos){
        super(btnText);
        try {
            InputStream inputStream = new BufferedInputStream(
                    new FileInputStream("Adamant_BG.otf"));

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);

            setFont(font.deriveFont(Font.BOLD, 16f));
            inputStream.close();
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        setBounds(x_pos, y_pos, 50, 55);
        setBackground(new Color(156, 169, 173));
    }


}
