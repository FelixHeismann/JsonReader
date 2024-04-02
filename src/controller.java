public class controller {
    private GameGui gui;
    private Reader reader; 
    public controller(){
        reader = new Reader();
        gui = new GameGui(reader.getRandomFrage(), this);
    }

    public void nextQuestion(){
        gui.changeButtons(reader.getRandomFrage());
    }
}
