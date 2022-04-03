import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String number1 = sc.nextLine();
        String number2 = sc.nextLine();
        String str = "";

        for (int i = 0; i < number1.length(); i++) {
            str += number1.charAt(i) + "" + number2.charAt(i);
        }

        while (str.length() > 2) {
            String temp = "";
            for (int i = 0; i < str.length() - 1; i++) {
                int a = str.charAt(i) - '0';
                int b = str.charAt(i + 1) - '0';
                temp += (a + b) % 10;
            }
            str = temp;
        }

        System.out.println(str);
    }
}