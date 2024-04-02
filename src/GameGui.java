import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameGui {
    private JButton a;
    private JButton b;
    private JButton c;
    private JButton d;
    private JLabel frage;
        public GameGui(Frage f, controller con){
            JFrame frame = new JFrame();
            frame.setSize(1920, 1080);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            a = addButtons(f.getAntworten().getA(),200, 200);
            b = addButtons(f.getAntworten().getB(),600, 200);
            c = addButtons(f.getAntworten().getC(),200, 600);
            d = addButtons(f.getAntworten().getD(),600, 600);
            frame.add(a);
            frame.add(b);
            frame.add(c);
            frame.add(d);
            frame.setBackground(Color.yellow);
            frame.setVisible(true);    
            frage = new JLabel();
            frage.setText(f.getFrage());
            frage.setSize(400, 100);
            frage.setBackground(Color.cyan);
            frame.add(frage);
            a.addActionListener(e -> selectionButtonPressed(f, a, con));
            b.addActionListener(e -> selectionButtonPressed(f, b, con));
            c.addActionListener(e -> selectionButtonPressed(f, c, con));
            d.addActionListener(e -> selectionButtonPressed(f, b, con));
        }

        public JButton addButtons(String text, int xc, int yc){
            JButton button = new JButton(text); 
            button.setSize(200, 100);
            button.setLocation(xc, yc);
            button.setBackground(Color.cyan); 
            return button;
        }

        public void selectionButtonPressed(Frage f, JButton j, controller con){
            System.out.println("gedrückt");
            System.out.println(j.getText());
            System.out.println(f.getRichtige_antwort());
            if(f.getRichtige_antwort()==j.getText()){
                System.out.println("richtig");
                con.nextQuestion();   
            }else{
                System.out.println("leider falsch :(");
            }
        }

        public void changeButtons(Frage f){
            a.setText(f.getAntworten().getA());
            b.setText(f.getAntworten().getB());
            c.setText(f.getAntworten().getC());
            d.setText(f.getAntworten().getD());
            frage.setText(f.getFrage());
        }
}
