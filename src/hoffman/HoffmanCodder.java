package hoffman;

public class HoffmanCodder implements HoffmanCode {
    private final Coder coder = new Coder();
    private final Decoder decoder = new Decoder();

    @Override
    public String coding(String text) {
        return coder.coding(text,new HoffmanTree(text));
    }

    @Override
    public String decoding(String code, String codeKey) {
        return decoder.decoding(code, new HoffmanTree(codeKey));
    }
}
