package hoffman;

public class Main {
    public static void main(String[] args) {
        HoffmanCodder hoffmanCodder = new HoffmanCodder();
        String coding = hoffmanCodder.coding("abcabcabc");
        System.out.println(coding);
        String decoding = hoffmanCodder.decoding(coding, "abcabcabc");
        System.out.println(decoding);
    }
}
