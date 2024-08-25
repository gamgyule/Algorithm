import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();

        String line = sc.nextLine();
        int bowman[] = Arrays.stream(line.split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        int maxKill = 0;

        for (int i = 0; i < bowman.length; i++) {
            int kill = 0;
            for (int j = i + 1; j < bowman.length; j++) {
                if (bowman[i] > bowman[j]) {
                    kill++;
                    if (maxKill < kill) {
                        maxKill = kill;
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(maxKill);

    }
}
