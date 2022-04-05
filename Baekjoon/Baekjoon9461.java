import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int game = sc.nextInt();

        int max = Integer.MIN_VALUE;
        int arr[] = new int[game];
        for (int i = 0; i < game; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i])
                max = arr[i];
        }

        long dp[] = new long[max + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= max; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(dp[arr[i] - 1]);
        }
    }

}