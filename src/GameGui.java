import java.awt.Color;
import javax.swing.*;

public class GameGui {
    private JButton a;
    private JButton b;
    private JButton c;
    private JButton d;
    private JLabel frage;
    private Frage f;
    private JFrame frame;
    private controller control;
    private JButton endButton;
    private JLabel endLabel;
    private JLabel counter;
    
        public GameGui(Frage fr, controller con){
            counter = new JLabel(con.getCounter());
            f = fr;
            control = con;
            frame = new JFrame();
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
            frame.add(counter);
            counter.setLocation(300, 0);
            frame.setBackground(Color.yellow);
            frame.setVisible(true);    
            frage = new JLabel();
            frage.setText(f.getFrage());
            frage.setSize(400, 100);
            frage.setBackground(Color.cyan);
            frame.add(frage);
            a.addActionListener(e -> selectionButtonPressed(f, "a", con));
            b.addActionListener(e -> selectionButtonPressed(f, "b", con));
            c.addActionListener(e -> selectionButtonPressed(f, "c", con));
            d.addActionListener(e -> selectionButtonPressed(f, "d", con));
        }

        public JButton addButtons(String text, int xc, int yc){
            JButton button = new JButton(text); 
            button.setSize(200, 100);
            button.setLocation(xc, yc);
            button.setBackground(Color.cyan); 
            return button;
        }

        public void selectionButtonPressed(Frage f,String j, controller con){
            if(f.getRichtige_antwort().equals(j)){
                System.out.println("richtig");
                con.nextQuestion();   
                counter = con.getCounter();
            }else{
                System.out.println("leider falsch :(");
                con.end();
            }
        }

        public void changeButtons(Frage fra){
            a.setText(fra.getAntworten().getA());
            b.setText(fra.getAntworten().getB());
            c.setText(fra.getAntworten().getC());
            d.setText(fra.getAntworten().getD());
            frage.setText(fra.getFrage());
            f = fra;
        }

        public void endScreen(){
            frage.setVisible(false);
            a.setVisible(false);
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);
            String text = "vorbeiiii";
            endLabel = new JLabel("<html><span style='font-size:50px'>"+text+"</span></html>");
            endLabel.setSize(1000, 200);
            frame.add(endLabel);
            frame.setBackground(Color.red);
            endButton = new JButton("nochmal?");
            endButton.addActionListener(e -> restarter());
            frame.add(endButton);
            endButton.setSize(400, 100);
            endButton.setLocation(500, 200);
        }

        public void restarter(){
            a.setVisible(true);
            b.setVisible(true);
            c.setVisible(true);
            d.setVisible(true);
            frage.setVisible(true);
            endButton.setVisible(false);
            endLabel.setVisible(false);
            control.restart();
        }
    }
