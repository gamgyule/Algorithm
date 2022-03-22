package Algorithm.Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1260 {

    public static boolean[] dfsVisited;
    public static boolean[] bfsVisited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void mian(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, v = 0;
        n = sc.nextInt() + 1;
        m = sc.nextInt();
        v = sc.nextInt();
        sc.nextLine();

        dfsVisited = new boolean[n];
        bfsVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
            sc.nextLine();
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        DFS(v);
        System.out.printf("\n");
        BFS(v);

    }

    static void DFS(int i) {
        dfsVisited[i] = true;
        System.out.printf("%d ", i);

        for (int j = 0; j < graph.get(i).size(); j++) {
            int y = graph.get(i).get(j);
            if (!dfsVisited[y])
                DFS(y);
        }

    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(x);
        bfsVisited[x] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();
            System.out.printf("%d ", a);
            for (int j = 0; j < graph.get(a).size(); j++) {
                int y = graph.get(a).get(j);
                if (!bfsVisited[y]) {
                    queue.add(y);
                    bfsVisited[y] = true;
                }
            }
        }

    }

}
