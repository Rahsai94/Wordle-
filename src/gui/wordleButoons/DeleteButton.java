package gui.wordleButoons;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DeleteButton extends JButton {
    public DeleteButton(String btnText, int x_pos, int y_pos){
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
        setBounds(x_pos, y_pos, 70, 55);
        setBackground(new Color(186, 116, 213));
    }
}
