import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int idx = c - 'a';
            if (alpha[idx] == -1) {
                alpha[idx] = i;
            }

        }
        for (int i : alpha) {
            System.out.print(i + " ");
        }
    }

}