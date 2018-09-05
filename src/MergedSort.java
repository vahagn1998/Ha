public class MergedSort {
    public static void main(String[] args) {
        MergedSort mergedSort = new MergedSort();
        long[] array = new long[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = (long) (Math.random() * 1000);
        }
        long l = System.nanoTime();
        mergedSort.sort(array, 0, array.length - 1);
        System.out.println(System.nanoTime() - l);
    }

    void sort(long[] array, int lower, int upper) {
        if (lower < upper) {
            int mid = (lower + upper) / 2;
            sort(array, lower, mid);
            sort(array, mid + 1, upper);
            merge(array, lower, mid + 1, upper);
        }
    }

    private void merge(long[] outerArray, int lower, int high, int upper) {
        int start = lower;
        int mid = high - 1;
        int j = 0;
        int n = upper - lower + 1;
        long[] array = new long[n];
        while (lower <= mid && high <= upper) {
            long lowerVal = outerArray[lower];
            long upperVal = outerArray[high];
            if (lowerVal > upperVal) {
                array[j++] = upperVal;
                high++;
            } else {
                array[j++] = lowerVal;
                lower++;
            }
        }
        while (lower <= mid) {
            array[j++] = outerArray[lower++];
        }
        while (high <= upper) {
            array[j++] = outerArray[high++];
        }
        for (int i = 0; i < n; i++) {
            outerArray[start++] = array[i];
        }
    }
}
