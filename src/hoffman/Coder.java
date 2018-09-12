package hoffman;

public class Coder {
    public String coding(String text, HoffmanTree tree) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char word = text.charAt(i);
            if(tree.containsWord(word)) {
                stringBuilder.append(tree.coding(word));
            }
        }
        return stringBuilder.toString();
    }
}
