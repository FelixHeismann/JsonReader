import java.awt.Color;

import javax.swing.*;

public class GameGui {
    
        public GameGui(Frage f){
            JFrame frame = new JFrame();
            frame.setSize(1920, 1080);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(addButtons(f.getAntworten().getA(),200, 200));
            frame.add(addButtons(f.getAntworten().getB(),600, 200));
            frame.add(addButtons(f.getAntworten().getC(),200, 600));
            frame.add(addButtons(f.getAntworten().getD(),600, 600));
        }

        public JButton addButtons(String text, int xc, int yc){
            JButton button = new JButton(text); 
            button.setBackground(Color.red);   
            return button;
        }
}
