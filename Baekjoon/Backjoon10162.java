import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int A = 300; // 5분
        int B = 60; // 1분
        int C = 10; // 10초

        int count[] = new int[3];

        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();

        if (time >= A) {
            count[0] = time / A;
            time = time % A;
        }
        if (time >= B) {
            count[1] = time / B;
            time = time % B;
        }
        if (time >= C) {
            count[2] = time / C;
            time = time % C;
        }

        System.out.println(time == 0 ? count[0] + " " + count[1] + " " + count[2] : -1);
    }
}
