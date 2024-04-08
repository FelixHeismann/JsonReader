import java.io.File;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Reader {

    public List<Frage> ListeFragen;

    public Reader() {
        File file = new File("C:\\Quizspiel\\JsonReader\\lib\\Fragen.json");

        ObjectMapper mapper = new ObjectMapper();

        try {
            ListeFragen = mapper.readValue(file, new TypeReference<List<Frage>>(){});
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Frage getRandomFrage(){
        Random ran = new Random();
        int i = ran.nextInt(0, ListeFragen.size());
        return ListeFragen.get(i);
    }   

    public Frage getFrageIndex(int index){
        return ListeFragen.get(index);
    }

    public List getListe(){
        return ListeFragen;
    }

}

