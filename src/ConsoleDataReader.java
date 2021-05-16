import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ConsoleDataReader extends DataReader {


    @Override
    public Input getInput() throws IOException {
        System.out.println("Type Your input characters:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputCharactersFromUser = reader.readLine().toLowerCase(Locale.ROOT);

        Set<Character> result = getCharacters(inputCharactersFromUser);

        System.out.println("Type your phrase:");
        String text = reader.readLine().toLowerCase(Locale.ROOT);

        return new Input(result,text);
    }
}
