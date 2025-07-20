import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 문제 1: 모든 순열
        int[] nums1 = {1, 2, 3};
        System.out.println("[문제 1] 모든 순열");
        System.out.println(permute(nums1));

        // 문제 2: 조합
        int n2 = 4, k2 = 2;
        System.out.println("[문제 2] 조합");
        System.out.println(combine(n2, k2));

        // 문제 3: 중복 조합
        int n3 = 3, m3 = 2;
        System.out.println("[문제 3] 중복 조합");
        System.out.println(duplicateCombinations(n3, m3));

        // 문제 4: 숫자 합 조건
        int[] nums4 = {2, 3, 6, 7};
        int target4 = 7;
        System.out.println("[문제 4] 숫자 합 조건");
        System.out.println(combinationSum(nums4, target4));

        // 문제 5: 유효한 괄호 조합
        int n5 = 3;
        System.out.println("[문제 5] 유효한 괄호 조합");
        System.out.println(generateParenthesis(n5));

        // 문제 5.5: B 제한 문자열 생성
        int n55 = 3;
        System.out.println("[문제 5.5] B 제한 문자열 생성");
        System.out.println(generateLimitedBString(n55));

        // 문제 5.6: C 2회 문자열 생성
        int n56 = 4;
        System.out.println("[문제 5.6] C 2회 문자열 생성");
        System.out.println(generateC2String(n56));

        // 문제 5.7: 인접한 동일 문자 금지 문자열 생성
        int n57 = 4;
        System.out.println("[문제 5.7] 인접한 동일 문자 금지 문자열 생성");
        System.out.println(generateNoRepeatString(n57));

        // 문제 6: 미로 탈출
        int[][] maze6 = {
                {0, 0, 1},
                {1, 0, 1},
                {1, 0, 0}
        };
        int[] start6 = {0, 0};
        int[] end6 = {2, 2};
        System.out.println("[문제 6] 미로 탈출");
        System.out.println(canReachExit(maze6, start6, end6));

        // 문제 7: N-Queen
        int n7 = 4;
        System.out.println("[문제 7] N-Queen");
        System.out.println(solveNQueens(n7));

        // 문제 8: 단어 검색
        char[][] board8 = {
                {'A', 'S', 'C', 'E'},
                {'S', 'C', 'C', 'S'},
                {'A', 'B', 'E', 'D'}
        };
        String word8 = "ABCCED"; // true
        System.out.println("[문제 8] 단어 검색");
        System.out.println(exist(board8, word8));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        sol1Backtrack(nums, visited, new ArrayList<>(), result);
        return result;
    }

    public static void sol1Backtrack(int[] nums, boolean[] visited, List<Integer> currentPath, List<List<Integer>> result){
        if(currentPath.size() == nums.length){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            currentPath.add(nums[i]);
            sol1Backtrack(nums, visited, currentPath, result);
            visited[i] = false;
            currentPath.removeLast();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        sol2Backtrak(0, n, k, new ArrayList<>(), result);
        return result;
    }

    public static void sol2Backtrak(int start, int len, int depth, List<Integer> currentPath, List<List<Integer>> result){
        if(currentPath.size() == depth){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for(int i = start; i < len; i++){
            currentPath.add(i+1);
            sol2Backtrak(i+1, len, depth, currentPath, result);
            currentPath.removeLast();
        }
    }

    public static List<List<Integer>> duplicateCombinations(int n, int m) {
        List<List<Integer>> result = new ArrayList<>();
        sol3Backtrack(0, n, m, new ArrayList<>(), result);
        return result;
    }

    public static void sol3Backtrack(int start, int len, int depth, List<Integer> currentPath, List<List<Integer>> result){
        if(currentPath.size() == depth){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for(int i = start; i < len; i++){
            currentPath.add(i+1);
            sol3Backtrack(i, len, depth, currentPath, result);
            currentPath.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        sol4Backtrack(nums, 0, target, new ArrayList<>(), 0, result);
        return result;
    }

    public static void sol4Backtrack(int[] nums, int index, int target, List<Integer> currentPath, int sum, List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(currentPath));
            return;
        } else if(sum > target){
            return;
        }

        for(int i = index; i < nums.length; i++){
            currentPath.add(nums[i]);
            sol4Backtrack(nums, i, target, currentPath, sum+nums[i], result);
            currentPath.removeLast();
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        sol5Backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    public static void sol5Backtrack(int len, int open, int close, StringBuilder sb, List<String> result){
        if(sb.length() == len*2){
            result.add(sb.toString());
            return;
        }

        if(open < len){
            sb.append("(");
            sol5Backtrack(len, open+1, close, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < len && open > close){
            sb.append(")");
            sol5Backtrack(len, open, close+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static List<String> generateLimitedBString(int n) {
        List<String> result = new ArrayList<>();
        sol5_5Backtrack(n, 0, new StringBuilder(), result);
        return result;
    }

    public static void sol5_5Backtrack(int size, int bLimit, StringBuilder sb, List<String> result){
        if(sb.length() == size){
            result.add(sb.toString());
            return;
        }

        if(bLimit < 1){
            sb.append("B");
            sol5_5Backtrack(size, bLimit+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }

        sb.append("A");
        sol5_5Backtrack(size, bLimit, sb, result);
        sb.deleteCharAt(sb.length()-1);
    }

    public static List<String> generateC2String(int n) {
        List<String> result = new ArrayList<>();
        sol5_6Backtrack(n, 0, new StringBuilder(), result);
        return result;
    }

    public static void sol5_6Backtrack(int len, int useC, StringBuilder sb, List<String> result){
        if(sb.length() == len){
            if(useC == 2) result.add(sb.toString());
            return;
        }

        sb.append("A");
        sol5_6Backtrack(len, useC, sb, result);
        sb.deleteCharAt(sb.length()-1);

        sb.append("B");
        sol5_6Backtrack(len, useC, sb, result);
        sb.deleteCharAt(sb.length()-1);

        if(useC < 2){
            sb.append("C");
            sol5_6Backtrack(len, useC+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static List<String> generateNoRepeatString(int n) {
        List<String> result = new ArrayList<>();
        String[] word = new String[]{"A","B","C"};

        sol5_7Backtrack(n, word, "", new StringBuilder(), result);

        return result;
    }

    public static void sol5_7Backtrack(int len, String[] words, String prevStr, StringBuilder sb, List<String> result){
        if(sb.length() == len){
            result.add(sb.toString());
            return;
        }

        for(String w : words){
            if(w.equals(prevStr)) continue;
            sb.append(w);
            sol5_7Backtrack(len, words, w, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static boolean canReachExit(int[][] maze, int[] start, int[] end) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        visited[start[0]][start[1]] = true;
        return sol6Backtrack(maze, start[0], start[1], end[0], end[1], dx, dy, visited);
    }

    public static boolean sol6Backtrack(int[][] maze, int x, int y, int ex, int ey, int[] dx, int[] dy, boolean[][] visited){
        if(x == ex && y == ey){
            return true;
        }

        for(int i = 0; i < dx.length; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextX < maze.length && nextY < maze[0].length){
                if(visited[nextX][nextY] && maze[nextX][nextY] == 1) continue;
                visited[nextX][nextY] = true;
                if(sol6Backtrack(maze, nextX, nextY, ex, ey, dx, dy, visited)) return true;
                visited[nextX][nextY] = false;
            }
        }
        return false;
    }

    public static int solveNQueens(int n) {
        return sol7Backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    public static int sol7Backtrack(int cols, int n, Set<Integer> rows, Set<Integer> diag1, Set<Integer> diag2){
        if(cols == n) return 1;

        int count = 0;

        for(int row = 0; row < n; row++){
            int diag1n = cols+row;
            int diag2n = cols-row;

            if(rows.contains(row) || diag1.contains(diag1n) || diag2.contains(diag2n)) continue;
            rows.add(row);
            diag1.add(diag1n);
            diag2.add(diag2n);

            count += sol7Backtrack(cols+1, n, rows, diag1, diag2);

            rows.remove(row);
            diag1.remove(diag1n);
            diag2.remove(diag2n);
        }

        return count;
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (sol8Backtrack(board, visited, word, i, j, 1, dx, dy))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public static boolean sol8Backtrack(char[][] board, boolean[][] visited, String word,
                                        int x, int y, int index, int[] dx, int[] dy) {
        if (index == word.length()) return true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length) {
                if (!visited[nx][ny] && board[nx][ny] == word.charAt(index)) {
                    visited[nx][ny] = true;
                    if (sol8Backtrack(board, visited, word, nx, ny, index + 1, dx, dy))
                        return true;
                    visited[nx][ny] = false;
                }
            }
        }
        return false;
    }
}
