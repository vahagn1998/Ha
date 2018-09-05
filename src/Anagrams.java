import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;

public class Anagrams {
    static Set<String> result = new LinkedHashSet<>();

    public static void main(String[] args) {
        String t = "qwerty";
        int length = t.length();
        doAnagram(t, new StringBuilder());
        int i = 1;
        for (String s : result) {
            if(s.length() != length) {
                throw new RuntimeException();
            }
            System.out.println(i++ + " " + s);
        }
    }

    static void doAnagram(String word, StringBuilder tempAnagram) {
        int length = word.length();
        if(length == 1) {
            tempAnagram.append(word);
            result.add(tempAnagram.toString());
            tempAnagram.delete(tempAnagram.length() - length - 1, tempAnagram.length());
            return;
        }
        StringBuilder newWord = new StringBuilder(word);
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            tempAnagram.append(c);
            newWord.delete(i, i + 1);
            doAnagram(newWord.toString(), tempAnagram);
            newWord.insert(i, c);
        }
        if(tempAnagram.length() != 0) {
            tempAnagram.delete(tempAnagram.length() - 1, tempAnagram.length());
        }
    }
}
