package hoffman;

public class Decoder {
    public String decoding(String code, HoffmanTree tree) {
        StringBuilder result = new StringBuilder();
        StringBuilder builderForCode = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            builderForCode.append(code.charAt(i));
            if (tree.containsCode(builderForCode.toString())) {
                result.append(tree.decoding(builderForCode.toString()));
                builderForCode.setLength(0);
            }
        }
        return result.toString();
    }
}
