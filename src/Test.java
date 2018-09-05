import java.io.RandomAccessFile;

public class Test {
    public static void main(String[] args) {
        int x = 0, y = 0;
        if (x++ == 1 && y++ == 1) {
            y += 2;
        }
        System.out.println(x + y);
    }
}
