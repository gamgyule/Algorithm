package Algorithm.Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon1012 {
    static ArrayList<ArrayList<Integer>> node = new ArrayList<ArrayList<Integer>>();
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int[][] maze;
    static boolean visited[][];
    static int g = 0;
    static int n = 0;
    static int m = 0;
    static int k = 0;

    public static void mian(String[] args) {
        Scanner sc = new Scanner(System.in);
        g = sc.nextInt();
        sc.nextLine();
        int arr[] = new int[g];
        for (int i = 0; i < g; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            maze = new int[n][m];
            visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                sc.nextLine();
                maze[a][b] = 1;
            }
            int cnt = 0;
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < m; l++) {
                    if (maze[k][l] == 1 && visited[k][l] == false) {
                        cnt = cnt + 1;
                        dfs(k, l);
                    }
                }
            }
            arr[i] = cnt;
        }

        for (int i : arr) {
            System.out.println(i);
        }

    }

    static void dfs(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                continue;

            if (maze[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }
}