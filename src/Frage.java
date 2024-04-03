
public class Frage {
    int id;
    String frage;
    Antworten antworten;
    String richtige_antwort;
    int schwierigkeit;

    public Frage(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFrage() {
        return frage;
    }
    public void setFrage(String frage) {
        this.frage = frage;
    }
    public String getRichtige_antwort() {
        return richtige_antwort;
    }
    public void setRichtige_antwort(String richtige_antwort) {
        this.richtige_antwort = richtige_antwort;
    }
    public int getSchwierigkeit() {
        return schwierigkeit;
    }
    public void setSchwierigkeit(int schwierigkeit) {
        this.schwierigkeit = schwierigkeit;
    }
    public Antworten getAntworten() {
        return antworten;
    }
    public void setAntworten(Antworten antworten) {
        this.antworten = antworten;
    }
    

}
