public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.pow(3, 18));
    }

    long pow(long x, long y) {
        if (y == 1) {
            return x;
        }
        long r = pow(x * x, y / 2);
        if (y % 2 == 1) {
            r *= x;
        }
        return r;
    }
}
