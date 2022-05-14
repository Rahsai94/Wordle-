package gui.wordleBox;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InstructionBox extends JPanel {
    BufferedImage myPicture = ImageIO.read(new File("instructions.png"));
    public InstructionBox() throws IOException {
        setSize(500, 500);
        setBounds(0,0,500,530);
        Image img = myPicture.getScaledInstance(500, 500,Image.SCALE_SMOOTH);
        ImageIcon imcon = new ImageIcon(img);
        JLabel picLabel = new JLabel(imcon);
        picLabel.setSize(new Dimension(500, 600));
        add(picLabel);
    }
}


