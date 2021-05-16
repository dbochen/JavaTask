import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Category {
    private Set<Character> characters;
    private int wordLength;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return wordLength == category.wordLength && characters.equals(category.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characters, wordLength);
    }

    @Override
    public String toString() {

        return "{" + characters + ", " + wordLength + "}";
    }


    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }


    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }
}
