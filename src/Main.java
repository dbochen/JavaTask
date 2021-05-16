import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args)  {

        Input input = null;
        try {
            input = getInput();
        } catch (IOException e) {
            System.out.println("Problem with reading input data. Error message: "+ e.getMessage());
            System.exit(0);
        }
        Set<Character> inputCharacters = input.getCharacters();
        String inputText = input.getText();

        String[] inputWords = inputText.split("[ !\"#$%&'()*+,./:;<=>?@\\[\\]^_`{|}~\\\\-]");


        Map<Category, Integer> categoryToAppearances = new HashMap<>();
        int inputCharactersCount = 0;
        int totalAppearanceOfInputChars = 0;

        for (String currentWord : inputWords) {
            Category category = new Category();
            int currentWordLen = currentWord.length();
            category.setWordLength(currentWordLen);
            inputCharactersCount += currentWordLen;

            Set<Character> categoryCharacters = new HashSet<>();
            int appearances = 0;

            for (int i = 0; i < currentWord.length(); i++) {
                char currentChar = currentWord.charAt(i);
                if (inputCharacters.contains(currentChar)) {
                    categoryCharacters.add(currentChar);
                    appearances++;
                }
            }


            totalAppearanceOfInputChars += appearances;
            category.setCharacters(categoryCharacters);
            if (categoryToAppearances.containsKey(category)) {
                int previousValue = categoryToAppearances.get(category);
                categoryToAppearances.put(category, appearances + previousValue);
            } else {
                categoryToAppearances.put(category, appearances);
            }
        }

        ;
        saveResultIfNeeded(printResult(categoryToAppearances, inputCharacters, totalAppearanceOfInputChars, inputCharactersCount));
    }

    private static String printResult(Map<Category, Integer> categoryToAppearances, Set<Character> inputCharacters, int totalAppearanceOfInputChars, int inputCharactersCount) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        StringBuilder message = new StringBuilder();

        for (int i = 1; i < inputCharacters.size() + 1; i++) {

            for (HashMap.Entry<Category, Integer> mapElement : categoryToAppearances.entrySet()) {
                Integer appearances = mapElement.getValue();
                if (i == appearances) {
                    double decimalAppearance = appearances / (double) totalAppearanceOfInputChars;

                    message.append(mapElement.getKey())
                            .append(" = ")
                            .append(decimalFormat.format(decimalAppearance))
                            .append(" (")
                            .append(appearances)
                            .append("/")
                            .append(totalAppearanceOfInputChars)
                            .append(")")
                            .append("\n");
                }
            }
        }
        double totalFrequency = (double) totalAppearanceOfInputChars / inputCharactersCount;
        message.append("TOTAL Frequency: ")
                .append(decimalFormat.format(totalFrequency))
                .append(" (")
                .append(totalAppearanceOfInputChars)
                .append("/")
                .append(inputCharactersCount)
                .append(")");

        System.out.println(message);
        return message.toString();

    }

    private static Input getInput() throws IOException {
        System.out.println("How do You want to enter data?" +
                "\n\r 1- from console" +
                "\n\r 2- from file");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String choice = reader.readLine();

        DataReader dataReader;

        if (choice.equals("1")) {
            dataReader = new ConsoleDataReader();

        } else {
            dataReader = new FileDataReader();
        }

        return dataReader.getInput();
    }

    public static void saveResultIfNeeded (String data) {
        System.out.println("Do You want to save result in txt file?" +
                "\n\r1- Yes" +
                "\n\r2- No");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String answer = reader.readLine();

            if (answer.equals("1")) {
                System.out.println("Type file direction:");
                String path = reader.readLine();
                FileWriter writer = new FileWriter(path);
                writer.write(data);
                writer.close();
            }
        }catch (IOException e){
            System.out.println("Problem with writing data. Error message: "+ e.getMessage());
        }
    }
}
