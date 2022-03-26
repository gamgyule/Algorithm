import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[][] visited;
    static int[][] pictures;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    public int[] solution(int m, int n, int[][] picture) {
        pictures = picture;
        visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pictures[i][j] != 0 && !visited[i][j]) {
                    int target = pictures[i][j];
                    numberOfArea++;
                    visited[i][j] = true;
                    int maxCnt = bfs(pictures, new Pos(i, j), target);
                    if (maxCnt > maxSizeOfOneArea)
                        maxSizeOfOneArea = maxCnt;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static class Pos {
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    static int bfs(int[][] picture, Pos pos, int target) {
        Queue<Pos> q = new LinkedList<>();
        int count = 1;
        q.add(pos);
        visited[pos.x][pos.y] = true;
        while (!q.isEmpty()) {
            Pos _pos = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextX = _pos.x + dx[i];
                int nextY = _pos.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < pictures.length && nextY < pictures[0].length) {
                    if (pictures[nextX][nextY] == target && !visited[nextX][nextY]) {
                        count++;
                        visited[nextX][nextY] = true;
                        q.add(new Pos(nextX, nextY));
                    }

                }

            }
        }
        return count;
    }
}