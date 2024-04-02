import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Reader {

    public static List<Frage> ListeFragen;

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Quizspiel\\JsonReader\\lib\\Fragen.json");

        ObjectMapper mapper = new ObjectMapper();

        try {
            ListeFragen = mapper.readValue(file, new TypeReference<List<Frage>>(){});
            for(Frage frage : ListeFragen){
                System.out.println(frage.frage);
            }
        } catch (JsonProcessingException ex) {
            System.out.println(ex.toString());
            return;
        }
    }


}

