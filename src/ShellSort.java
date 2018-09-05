import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        long[] array = new long[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = (long) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(array));
        long l = System.nanoTime();
        shellSort.sort(array);
        System.out.println(System.nanoTime() - l);
        System.out.println(Arrays.toString(array));
    }

    public void sort(long[] array) {
        int length = array.length;
        int h = calculateH(length);
        while (h > 0) {
            for (int i = h; i < length; i += h) {
                int current = i;
                for (int j = i - h; j >= 0; j -= h) {
                    if (array[current] < array[j]) {
                        long temp = array[current];
                        array[current] = array[j];
                        array[j] = temp;
                        current = j;
                    } else {
                        break;
                    }
                }
            }
            h = (h - 1) / 3;
        }
    }

    private int calculateH(int length) {
        int h = 1;
        while (h < length) {
            h = 3 * h + 1;
        }
        return (h - 1) / 3;
    }
}
