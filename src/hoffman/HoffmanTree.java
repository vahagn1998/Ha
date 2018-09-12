package hoffman;

import java.util.*;

public class HoffmanTree {
    private Map<Character, String> tableCoding = new HashMap<>();
    private Map<String, Character> tableDecoding = new HashMap<>();
    private String currentText;

    public HoffmanTree(String currentText) {
        constructHoffmanTable(currentText);
    }

    public String coding(char word) {
        return tableCoding.get(word);
    }

    public char decoding(String code) {
        return tableDecoding.get(code);
    }

    public boolean containsCode(String code) {
        return tableDecoding.containsKey(code);
    }

    public boolean containsWord(char word) {
        return tableCoding.containsKey(word);
    }

    private void constructHoffmanTable(String text) {
        if (text != null && !Objects.equals(currentText, text)) {
            Map<Character, Integer> countOfWords = new HashMap<>();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                Integer integer = countOfWords.get(c);
                if (integer == null) {
                    countOfWords.put(c, 1);
                } else {
                    countOfWords.put(c, ++integer);
                }
            }

            LinkedList<Tree.Node<Integer, Object>> stack = new LinkedList<>();
            for (Map.Entry<Character, Integer> entry : countOfWords.entrySet()) {
                stack.addLast(new Tree.Node<>(entry.getValue(), entry.getKey()));
            }

            Comparator<Tree.Node<Integer, Object>> comparator = Comparator.comparing(Tree.Node::getKey);
            stack.sort(comparator);

            while (stack.size() > 1) {
                Tree.Node<Integer, Object> first = stack.pop();
                Tree.Node<Integer, Object> second = stack.pop();
                Tree.Node<Integer, Object> parentNode = new Tree.Node<>(second.getKey() + first.getKey(), null);
                parentNode.left = first;
                parentNode.right = second;
                stack.addFirst(parentNode);
                stack.sort(comparator);
            }
            Tree.Node<Integer, Object> root = stack.pop();
            currentText = text;

            postOrder(root, "");
            System.out.println();
        }
    }

    private void postOrder(Tree.Node branch, String code) {
        if (branch == null) {
            return;
        }
        postOrder(branch.left, code.concat("0"));
        postOrder(branch.right, code.concat("1"));
        Object value = branch.getValue();
        if(value instanceof Character) {
            tableCoding.put((Character) value, code);
            tableDecoding.put(code, (Character) value);
        }
    }

    public void setCurrentText(String currentText) {
        constructHoffmanTable(currentText);
    }

    public String getCurrentText() {
        return currentText;
    }
}
