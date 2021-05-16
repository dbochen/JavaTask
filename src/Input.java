import java.util.List;
import java.util.Set;

public class Input {
    private Set<Character> characters;
    private String text;

    public Input(Set<Character> characters, String text) {
        this.characters = characters;
        this.text = text;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public String getText() {
        return text;
    }
}
