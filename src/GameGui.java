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
    private JButton highscore;
    private JButton wwm;
    private JButton menuButton;

    private boolean mitDiff;

    private JLabel menu;
    private JLabel frage;
    private JLabel endLabel;
    private JLabel counter;
    
    
        public GameGui(Frage fr, Controller con){
            f = fr;
            control = con;

            frame = new JFrame("Quizspiel");
            frame.setSize(width, height);
            frame.setVisible(true);
            frame.setLayout(null); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            
            a = addButtons("A: " + f.getAntworten().getA(), CENTER_WIDTH - 300, CENTER_HEIGHT - 100);
            b = addButtons("B: " + f.getAntworten().getB(), CENTER_WIDTH + 100, CENTER_HEIGHT - 100);
            c = addButtons("C: " + f.getAntworten().getC(), CENTER_WIDTH - 300, CENTER_HEIGHT + 100);
            d = addButtons("D: " + f.getAntworten().getD(), CENTER_WIDTH + 100, CENTER_HEIGHT + 100);
            
            counter = new JLabel("<html><span style='font-size:40px'>"+"Score: "+Integer.toString(con.getCounter())+"</span></html>");
            counter.setLocation(1500, 100);
            counter.setVisible(true);
            counter.setBackground(Color.red);
            counter.setSize(400, 100);     
            
            String text = "Das Spiel ist vorbei.";
            endLabel = new JLabel("<html><span style='font-size:40px'>"+text+"</span></html>");
            endLabel.setSize(1000, 200);
            endLabel.setLocation(width/2 - +endLabel.getWidth()/2, 0);

            endButton = new JButton("Nochmal?");
            endButton.setSize(400, 100);
            endButton.setLocation(width/2 - endButton.getWidth()/2, height/2 - endButton.getHeight()/2);
            endButton.addActionListener(e -> restarter());

            menu = new JLabel("<html><span style='font-size:40px'>"+"Hauptmenü"+"</span></html>");
            menu.setLocation(CENTER_WIDTH-300, 100);
            menu.setSize(600, 150);
            menu.setBackground(Color.cyan);

            menuButton = new JButton("Hauptmenü");
            menuButton.setSize(300, 100);
            menuButton.setBackground(Color.lightGray);
            menuButton.addActionListener(e -> menu());
            menuButton.setLocation(100, 100);

            highscore = new JButton("Highscore");
            highscore.setLocation(CENTER_WIDTH-300, CENTER_HEIGHT-100);
            highscore.addActionListener(e -> gamestartHs());
            highscore.setSize(400, 100);
            highscore.setBackground(Color.cyan);

            wwm = new JButton("Wer wird Millionär");
            wwm.setLocation(CENTER_WIDTH-300, CENTER_HEIGHT+100);
            wwm.addActionListener(e -> gamestartWWM());
            wwm.setSize(400, 100);
            wwm.setBackground(Color.cyan);

            frame.add(a);
            frame.add(b);
            frame.add(c);
            frame.add(d);
            frame.add(counter);
            frame.add(menu);
            frame.add(highscore);
            frame.add(wwm);
            frame.add(menuButton);            
            frame.add(endLabel);
            frame.add(endButton);

            highscore.setVisible(true);
            menu.setVisible(true);
            wwm.setVisible(true);

            frame.getContentPane().setBackground(Color.YELLOW);
            frage = new JLabel();
            frage.setText(f.getFrage());
            frage.validate();
            frage.setSize(800, 100);
            frage.setOpaque(true);
            frage.setBackground(Color.CYAN);
            frage.setLocation((CENTER_WIDTH - frage.getWidth()/2), 0);
            //System.out.println(javax.swing.UIManager.getDefaults().getFont("Label.font"));
        
            frame.add(frage);
            a.addActionListener(e -> selectionButtonPressed(f, "a", con));
            b.addActionListener(e -> selectionButtonPressed(f, "b", con));
            c.addActionListener(e -> selectionButtonPressed(f, "c", con));
            d.addActionListener(e -> selectionButtonPressed(f, "d", con));

            frage.setVisible(false);
            a.setVisible(false);
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);
            endLabel.setVisible(false);
            endButton.setVisible(false);

        }

        public JButton addButtons(String text, int xc, int yc){
            JButton button = new JButton(text); 
            button.setSize(QUESTION_BUTTONS_WIDTH, QUESTION_BUTTONS_HEIGHT);
            button.setLocation(xc, yc);
            button.setBackground(Color.CYAN); 
            return button;
        }

        public void gamestartHs(){
            mitDiff = false;
            a.setVisible(true);
            b.setVisible(true);
            c.setVisible(true);
            d.setVisible(true);
            frage.setVisible(true);
            highscore.setVisible(false);
            menu.setVisible(false);
            wwm.setVisible(false);
        }

        public void gamestartWWM(){
            mitDiff = true;
            a.setVisible(true);
            b.setVisible(true);
            c.setVisible(true);
            d.setVisible(true);
            frage.setVisible(true);
            highscore.setVisible(false);
            menu.setVisible(false);
            wwm.setVisible(false);
        }

        public void selectionButtonPressed(Frage f, String j, Controller con){
            if(f.getRichtige_antwort().equals(j)){
                System.out.println("richtig");
                if(!mitDiff){
                    control.nextQuestion();   
                    counter.setText("<html><span style='font-size:40px'>"+"Score: "+Integer.toString(con.getCounter())+"</span></html>");
                }else{
                    control.add1ToCounter();
                    control.nextQuestionDifficulty();
                    System.out.println("erreicht");
                }
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
            counter.setText("<html><span style='font-size:40px'>"+"Score: "+Integer.toString(control.getCounter())+"</span></html>");
            f = fra;
        }

        public void endScreen(){
            frage.setVisible(false);
            a.setVisible(false);
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);
            endLabel.setVisible(true);
            endButton.setVisible(true);          
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

        public void menu(){
            endButton.setVisible(false);
            endLabel.setVisible(false);

            frage.setVisible(false);
            a.setVisible(false);
            b.setVisible(false);
            c.setVisible(false);
            d.setVisible(false);

            menu.setVisible(true);
            wwm.setVisible(true);
            highscore.setVisible(true);
        }
    }


