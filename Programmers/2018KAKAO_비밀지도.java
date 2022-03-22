package Algorithm.Programmers;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] maze1 = new int[n][n];
        int[][] maze2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            String number1 = String.format("%0" + n + "d",
                    Long.parseLong(Integer.toBinaryString(arr1[i]).toString()));
            String number2 = String.format("%0" + n + "d",
                    Long.parseLong(Integer.toBinaryString(arr2[i]).toString()));
            for (int j = 0; j < n; j++) {
                int bn1 = number1.charAt(j) - '0';
                int bn2 = number2.charAt(j) - '0';
                maze1[i][j] = bn1;
                maze2[i][j] = bn2;
            }
        }
        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < n; j++) {
                temp += (maze1[i][j] + maze2[i][j]) >= 1 ? "#" : " ";
            }
            answer[i] = temp;
        }
        return answer;
    }
}