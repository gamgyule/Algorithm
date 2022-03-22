package Algorithm.Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon7576 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int n = 0;
    static int m = 0;

    public static void mian(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    q.add(new Pos(i, j));
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        int max = -999;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }

                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        if (max < 1) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }

    static Queue<Pos> q = new LinkedList<>();

    public static void bfs() {
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextX = pos.x + dx[i];
                int nextY = pos.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (arr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        q.add(new Pos(nextX, nextY));
                        arr[nextX][nextY] = arr[pos.x][pos.y] + 1;
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }

    public static class Pos {
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }
}
