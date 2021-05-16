import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileDataReader extends DataReader {
    @Override
    public Input getInput() throws IOException {
        System.out.println("Type file path:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new java.io.FileReader(filePath));

        String characters = fileReader.readLine();

        StringBuilder inputText = new StringBuilder();

        while (fileReader.ready()){
            inputText.append(fileReader.readLine());
        }
        Set<Character> charactersList = getCharacters(characters);

        return new Input(charactersList,inputText.toString());
    }
}
