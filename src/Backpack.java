import java.util.Set;

public class Backpack {

    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        System.out.println(backpack.fill(new int[]{20, 5, 5, 10}, 20, 0, 0));
    }
    int fill(int[] items, int target, int sum, int index) {
        int s = target + sum;
        if(target < 0) {
            return 0;
        }
        if(target == sum) {
            return 1;
        }
        int r = 0;
        for (int i = index; i < items.length; i++) {
            sum += items[i];
            if(sum <= s) {
                r += fill(items, target - items[i], sum, index + 1);
            }
            sum -= items[i];
        }
        return r;
    }
}
