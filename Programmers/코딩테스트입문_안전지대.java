package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0 } }));
    }

    public static int solution(int[][] arr) {
        List<int[]> indexList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    indexList.add(new int[] { i, j });
                }
            }
        }

        for (int i = 0; i < indexList.size(); i++) {
            boomArea(arr, indexList.get(i)[0], indexList.get(i)[1]);
        }

        int count = (int) Arrays.stream(arr).flatMapToInt(Arrays::stream).filter(i -> i == 0).count();
        return count;
    }

    public static void boomArea(int[][] arr, int x, int y) {
        int[] dx = { 1, -1, 0, 0, 1, -1, -1, 1 };
        int[] dy = { 0, 0, 1, -1, -1, 1, -1, 1 };

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= arr.length || nextY < 0 || nextY >= arr[0].length)
                continue;

            if (arr[nextX][nextY] == 0) {
                arr[nextX][nextY] = 1;
            }
        }
    }

}