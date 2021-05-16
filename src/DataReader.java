import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DataReader {

    public abstract Input getInput () throws IOException;

    public Set<Character> getCharacters (String inputCharactersFromUser){
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < inputCharactersFromUser.length(); i++) {
            result.add(inputCharactersFromUser.charAt(i));
        }
        return result;
    }
}
