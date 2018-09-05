public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 5, 9, 10, 16}, 5, 0, 5));
    }

    static int search(int[] arr, int key, int lower, int upper) {
        int current = (lower + upper) / 2;
        if(arr[current] == key) {
            return current;
        } else if(lower > upper) {
            return -1;
        } else {
            if(arr[current] < key) {
                search(arr, key, current + 1, upper);
            } else {
                search(arr, key, lower, current - 1);
            }
        }
        return -1;
    }
}
