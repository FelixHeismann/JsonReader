public class main {
    public static void main(String[] args){
        Reader reader = new Reader();
        GameGui gui = new GameGui(reader.getRandomFrage());
    }
}
