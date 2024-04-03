public class controller {
    private int counter;
    private GameGui gui;
    private Reader reader; 
    public controller(){
        reader = new Reader();
        counter = 1;
        gui = new GameGui(reader.getRandomFrage(), this);
    }

    public void nextQuestion(){
        counter++;
        gui.changeButtons(reader.getRandomFrage());
    }

    public void end(){
        gui.endScreen();
    }
}
