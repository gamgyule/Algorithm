package Algorithm.Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1697 {

    static int a = 0;
    static int b = 0;

    public static void mian(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine();
        if (a == b) {
            System.out.println("0");
        } else {
            bfs(a, b, 0);
        }
    }

    public static void bfs(int n, int m, int cnt) {
        boolean[] visited = new boolean[100001];
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(n, 0));
        visited[n] = true;
        while (!q.isEmpty()) {
            Pos pos = q.poll();

            if (pos.x == m) {
                System.out.println(pos.cnt);
                break;
            }

            int case1 = pos.x + 1;
            int case2 = pos.x - 1;
            int case3 = pos.x * 2;

            if (case1 >= 0 && case1 <= 100000 && !visited[case1]) {
                q.add(new Pos(case1, pos.cnt + 1));
                visited[case1] = true;
            }

            if (case2 >= 0 && case2 <= 100000 && !visited[case2]) {
                q.add(new Pos(case2, pos.cnt + 1));
                visited[case2] = true;
            }

            if (case3 >= 0 && case3 <= 100000 && !visited[case3]) {
                q.add(new Pos(case3, pos.cnt + 1));
                visited[case3] = true;
            }
        }
    }

    public static class Pos {
        int x;
        int cnt;

        Pos(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
