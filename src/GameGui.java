import java.awt.Color;

import javax.swing.*;

public class GameGui {
    // Frage f ist eigentlich überflüssig
    private Frage f;
    private Controller control;

    private int width = 1920;
    private int height = 1080;
    final private int CENTER_WIDTH = width/2;
    final private int CENTER_HEIGHT = height/2; 
    final private int QUESTION_BUTTONS_WIDTH = 200;
    final private int QUESTION_BUTTONS_HEIGHT = 100;

    private JFrame frame;
    
    private JButton a;
    private JButton b;
    private JButton c;
    private JButton d;
    private JButton endButton;

    private JLabel frage;
    private JLabel endLabel;
    private JLabel counter;
    
    
        public GameGui(Frage fr, Controller con){
            f = fr;
            control = con;
            
            counter = new JLabel(Integer.toString(con.getCounter()));
            counter.setLocation(1000, 300);

            frame = new JFrame("Quizspiel");
            frame.setSize(width, height);
            frame.setVisible(true);
            frame.setLayout(null); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            
            a = addButtons("A: " + f.getAntworten().getA(), width/2 - 300, height/2 - 100);
            b = addButtons("B: " + f.getAntworten().getB(), width/2 + 100, height/2 - 100);
            c = addButtons("C: " + f.getAntworten().getC(), width/2 - 300, height/2 + 100);
            d = addButtons("D: " + f.getAntworten().getD(), width/2 + 100, height/2 + 100);
            
            frame.add(a);
            frame.add(b);
            frame.add(c);
            frame.add(d);
            frame.add(counter); 

            frame.getContentPane().setBackground(Color.YELLOW);
            frage = new JLabel();
            frage.setText(f.getFrage());
            frage.validate();
            frage.setSize(400, 100);
            frage.setOpaque(true);
            frage.setBackground(Color.CYAN);
            frage.setLocation((width/2 - frage.getWidth()/2), 0);
            //System.out.println(javax.swing.UIManager.getDefaults().getFont("Label.font"));
        
            frame.add(frage);
            a.addActionListener(e -> selectionButtonPressed(f, "a", con));
            b.addActionListener(e -> selectionButtonPressed(f, "b", con));
            c.addActionListener(e -> selectionButtonPressed(f, "c", con));
            d.addActionListener(e -> selectionButtonPressed(f, "d", con));
        }

        public JButton addButtons(String text, int xc, int yc){
            JButton button = new JButton(text); 
            button.setSize(QUESTION_BUTTONS_WIDTH, QUESTION_BUTTONS_HEIGHT);
            button.setLocation(xc, yc);
            button.setBackground(Color.CYAN); 
            return button;
        }

        public void selectionButtonPressed(Frage f, String j, Controller con){
            if(f.getRichtige_antwort().equals(j)){
                System.out.println("richtig");
                con.nextQuestion();   
                counter.setText(Integer.toString(con.getCounter()));
            }else{
                System.out.println("leider falsch :(");
                endScreen();
            }
        }

        public void changeButtons(Frage fra){
            a.setText("A: " + fra.getAntworten().getA());
            b.setText("B: " + fra.getAntworten().getB());
            c.setText("C: " + fra.getAntworten().getC());
            d.setText("D: " + fra.getAntworten().getD());
            frage.setText(fra.getFrage());
            frage.validate();
            f = fra;
        }

        public void endScreen(){
            frage.setVisible(false);
            a.setVisible(false);
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);
            
            String text = "Das Spiel ist vorbei.";
            endLabel = new JLabel("<html><span style='font-size:50px'>"+text+"</span></html>");
            endLabel.setSize(1000, 200);
            endLabel.setLocation(width/2 - endLabel.getWidth()/2, 0);
            endButton = new JButton("Nochmal?");
            endButton.setSize(400, 100);
            endButton.setLocation(width/2 - endButton.getWidth()/2, height/2 - endButton.getHeight()/2);
            endButton.addActionListener(e -> restarter());
            
            frame.add(endLabel);
            frame.setBackground(Color.red);
            frame.add(endButton);
            
            
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


