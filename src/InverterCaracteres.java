import java.util.ArrayList;
import java.util.List;

public class InverterCaracteres {

    public static void main(String[] args) {
        String word = "abcd";

        List<Character> characters = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            characters.add(word.charAt(i));
        }
        word = "";
        for (int i = characters.size() - 1; i >= 0; i--) {
            word += characters.get(i);
        }
        System.out.println(word);
    }
}
