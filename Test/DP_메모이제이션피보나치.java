
public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(func(40));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    static int save[] = new int[41];

    private static int func(int n) {

        if (save[n] > 0) {
            return save[n];
        }

        if (n == 0) {
            return save[n] = 0;
        }
        if (n == 1) {
            return save[n] = 1;
        }

        return save[n] = func(n - 1) + func(n - 2);

    }
}