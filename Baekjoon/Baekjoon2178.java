package Algorithm.Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

public class Baekjoon2178 {
    static int maze[][];
    static boolean bfsVisited[][];
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int n = 0;
    static int m = 0;

    public static void mian(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        bfsVisited = new boolean[n][m];
        maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            char[] test = line.toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = test[j] - '0';
            }
        }

        bfs(0, 0);
        System.out.println(maze[n - 1][m - 1]);
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<Point>();
        bfsVisited[x][y] = true;
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;

                if (bfsVisited[nextX][nextY] == true || maze[nextX][nextY] == 0)
                    continue;

                q.add(new Point(nextX, nextY));
                maze[nextX][nextY] = maze[p.x][p.y] + 1;
                bfsVisited[nextX][nextY] = true;

            }
        }
    }
}