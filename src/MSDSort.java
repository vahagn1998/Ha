import java.util.*;

public class MSDSort {

    public static void main(String[] args) {
        MSDSort msdSort = new MSDSort();
        long[] array = {170, 45, 75, 90, 2, 802, 2, 66};
        msdSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(long[] array) {
        long asLong = Arrays.stream(array).max().getAsLong();
        sort(array, (int) Math.log10(asLong));
    }

    public void sort(long[] array, int level) {
        if(level == 0) {
            return;
        }
        Map<Long, List<Long>> arrayMap = new TreeMap<>();
        for (long l : array) {
            long o = l / ((long) Math.pow(10, level));
            List<Long> longs = arrayMap.get(o);
            if (longs == null) {
                List<Long> v = new ArrayList<>();
                v.add(l);
                arrayMap.put(o, v);
            } else {
                longs.add(l);
            }
        }
        int i = 0;
        for (List<Long> value : arrayMap.values()) {
            for (Long aLong : value) {
                array[i++] = aLong;
            }
        }
        sort(array, level - 1);
    }
}
