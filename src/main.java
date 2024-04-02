public class Main {
    public static void main(String[] args){
        Reader reader = new Reader();
        GameGui gui = new GameGui(reader.getRandomFrage());
    }
}
