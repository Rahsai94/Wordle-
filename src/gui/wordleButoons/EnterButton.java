package gui.wordleButoons;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EnterButton extends JButton {
    public EnterButton(String btnText, int x_pos, int y_pos) {
        super(btnText);
        try {
            InputStream inputStream = new BufferedInputStream(
                    new FileInputStream("Adamant_BG.otf"));

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);

            setFont(font.deriveFont(Font.BOLD, 12f));
            inputStream.close();
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        setBounds(x_pos, y_pos, 85, 55);
        setBackground(new Color(116, 170, 213));
    }
}
