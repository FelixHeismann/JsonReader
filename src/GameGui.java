import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameGui {

        public GameGui(Frage f){
            JFrame frame = new JFrame();
            frame.setSize(1920, 1080);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            JButton a = addButtons(f.getAntworten().getA(),200, 200);
            JButton b = addButtons(f.getAntworten().getB(),600, 200);
            JButton c = addButtons(f.getAntworten().getC(),200, 600);
            JButton d = addButtons(f.getAntworten().getD(),600, 600);
            frame.add(a);
            frame.add(b);
            frame.add(c);
            frame.add(d);
            frame.setBackground(Color.yellow);
            a.addActionListener(e -> selectionButtonPressed(a));
            b.addActionListener(e -> selectionButtonPressed(b));
            c.addActionListener(e -> selectionButtonPressed(c));
            d.addActionListener(e -> selectionButtonPressed(d));
            frame.setVisible(true);    
            JLabel frage = new JLabel();
            frage.setText(f.getFrage());
            frage.setSize(400, 100);
            frage.setBackground(Color.cyan);
            frame.add(frage);
        }

        public JButton addButtons(String text, int xc, int yc){
            JButton button = new JButton(text); 
            button.setSize(200, 100);
            button.setLocation(xc, yc);
            button.setBackground(Color.cyan); 
            return button;
        }

        public String selectionButtonPressed(JButton button){
            return button.getText();
        }
}
