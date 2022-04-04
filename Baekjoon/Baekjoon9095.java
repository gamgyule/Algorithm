import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int game = sc.nextInt();
        int num[] = new int[game];
        int max = -999;
        for (int i = 0; i < game; i++) {
            num[i] = sc.nextInt();
            if (max < num[i])
                max = num[i];
        }

        int dp[] = new int[max + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]);
        }

        for (int i = 0; i < game; i++) {
            System.out.println(dp[num[i]]);
        }
    }

}