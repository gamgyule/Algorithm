package Algorithm.Baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.awt.Point;

public class Baekjoon2667 {
    static int maze[][];
    static boolean bfsVisited[][];
    static boolean dfsVisited[][];
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int n = 0;
    static int m = 0;

    public static void mian(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        dfsVisited = new boolean[n][n];
        maze = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            char[] test = line.toCharArray();
            for (int j = 0; j < n; j++) {
                maze[i][j] = test[j] - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 1 && dfsVisited[i][j] == false) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);
        list.sort(Comparator.naturalOrder());
        for (Integer n : list) {
            System.out.println(n);
        }
    }

    static List<Integer> list = new ArrayList<>();

    static void dfs(int x, int y) {
        int cnt = 0;
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(x, y));
        dfsVisited[x][y] = true;
        cnt++;

        while (!stack.isEmpty()) {
            Point p = stack.pop();
            for (int i = 0; i < dx.length; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    if (maze[nextX][nextY] == 1 && dfsVisited[nextX][nextY] == false) {
                        stack.add(new Point(nextX, nextY));
                        dfsVisited[nextX][nextY] = true;
                        cnt++;
                    }
                }
            }
        }
        list.add(cnt);
    }
}