import java.util.*;

public class Controller {
    
    private int counter;
    private GameGui gui;
    private Reader reader; 
    private List<Frage> Fragen = new ArrayList<Frage>();

    public Controller(){
        reader = new Reader();
        counter = 0;
        gui = new GameGui(reader.getRandomFrage(), this);
    }

    public void nextQuestion(){
        counter++;
        Frage frage = reader.getRandomFrage();
        while (Fragen.contains(frage)) {
            frage = reader.getRandomFrage();
        } 
        Fragen.add(frage);
        gui.changeButtons(reader.getRandomFrage());
    }

    public void restart(){
        counter = 0;
        firstQuestion();
    }

    public void firstQuestion(){
        Frage frage = reader.getRandomFrage();
        while (Fragen.contains(frage)) {
            frage = reader.getRandomFrage();
        } 
        Fragen.add(frage);
        gui.changeButtons(reader.getRandomFrage());
    }

    public int getCounter(){
        return counter;
    }

    public void resetFragenliste(){
        this.Fragen = new ArrayList<Frage>();
    }
}

