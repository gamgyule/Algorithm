package Algorithm.Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon2606 {
    static ArrayList<ArrayList<Integer>> node = new ArrayList<ArrayList<Integer>>();
    static boolean dfsVisited[];
    static int n = 0;
    static int m = 0;

    public static void mian(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt() + 1;
        m = sc.nextInt();
        sc.nextLine();

        dfsVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            node.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();

            node.get(a).add(b);
            node.get(b).add(a);
        }

        dfs(1);
        int cnt = 0;
        for (boolean b : dfsVisited) {
            if (b == true)
                cnt++;
        }

        System.out.println(cnt - 1);
    }

    static void dfs(int num) {
        for (int i = 0; i < node.get(num).size(); i++) {
            int nextNum = node.get(num).get(i);
            if (dfsVisited[nextNum] == false) {
                dfsVisited[nextNum] = true;
                dfs(nextNum);
            }
        }
    }
}