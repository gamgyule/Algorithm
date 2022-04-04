import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        String str1 = input[0];
        String str2 = input[1];

        str1 = new StringBuffer(str1).reverse().toString();
        str2 = new StringBuffer(str2).reverse().toString();

        int a = Integer.parseInt(str1);
        int b = Integer.parseInt(str2);

        System.out.println((a > b) ? a : b);
    }

}