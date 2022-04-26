import java.util.Arrays;

public class Main {
    static int[] arr = { 1, 2, 3 };
    static boolean[] visited = new boolean[3];
    static int[] output = new int[3];

    public static void main(String[] args) {
        permutaion(1);
    }

    static void permutaion(int cnt) {
        if (cnt == 3) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;

            output[cnt] = arr[i];
            permutaion(cnt + 1);
            visited[i] = false;
        }
    }

}
