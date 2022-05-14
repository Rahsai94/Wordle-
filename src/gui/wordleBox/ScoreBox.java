package gui.wordleBox;

import wordle.Score;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ScoreBox extends JPanel {


        private JLabel label;
        private JProgressBar progressBar[] = new JProgressBar[6];
        private JLabel prograssLabel[] = new JLabel[6];
        private JLabel prograssLabelPer[] = new JLabel[6];


        public ScoreBox(){

            GridBagConstraints c = new GridBagConstraints();

            Border padding = BorderFactory.createEmptyBorder(20, 40, 20, 40);
            setBorder(padding);
            setBackground(Color.WHITE);
            setLayout(new GridBagLayout());

            label = new JLabel("STATISTICS");
            label.setFont(new Font("Serif",Font.BOLD, 20));
            c.fill = GridBagConstraints.CENTER;
            c.gridx = 1;
            c.gridy = 0;
            c.insets = new Insets(10,0,10,0);  //top padding
            add(label, c);


            JLabel gamePlayed = new JLabel("Played: "+Score.numberOfGames);
            JLabel winPer = new JLabel("WIn : 0 %");
            if(Score.WIN){
                winPer.setText("WIn : 100 %");
            }


            gamePlayed.setFont(new Font("Serif", Font.BOLD, 15));
            winPer.setFont(new Font("Serif", Font.BOLD, 15));


            c.fill = GridBagConstraints.LINE_START;
            c.gridx = 0;
            c.gridy = 2;
            c.weighty = 0.5;
            add(gamePlayed, c);


            c.fill = GridBagConstraints.LINE_END;
            c.gridx = 1;
            c.gridy = 2;
            c.weighty = 0.5;
            add(winPer, c);





            for (int i = 0; i < 6; i++) {

                prograssLabel[i] = new JLabel(""+(i+1)+"    ");;
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = 0;
                c.gridy = 3 + i;
                add(prograssLabel[i], c);

                progressBar[i] = new JProgressBar(JProgressBar.HORIZONTAL, 0, 5);;
                c.fill = GridBagConstraints.CENTER;
                c.gridx = 1;
                c.gridy = 3+i;
                c.weightx = 0.2;

                if(Score.scores.get(i) == null){
                    progressBar[i].setValue(0);
                }else {
                    progressBar[i].setValue(Score.scores.get(i));
                }

                add(progressBar[i], c);

                if(Score.scores.get(i) == null){
                    prograssLabelPer[i] = new JLabel("    "+0+" ");;
                }else {
                    prograssLabelPer[i] = new JLabel("    "+Score.scores.get(i)+" ");
                }
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = 2;
                c.gridy = 3 + i;
                c.weightx = 0.2;
                add(prograssLabelPer[i], c);

            }


            Border labelPad = BorderFactory.createEmptyBorder(10, 0, 10, 0);
            JLabel message = new JLabel("Do you wanna play again ? ");
            message.setFont(new Font("Serif", Font.BOLD, 20));
            message.setBorder(labelPad);

            c.fill = GridBagConstraints.CENTER;
            c.gridx = 1;
            c.gridy = 10;
            c.insets = new Insets(10,0,10,0);  //top padding
            add(message, c);

        }
}
