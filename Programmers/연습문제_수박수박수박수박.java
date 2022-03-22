package Algorithm.Programmers;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] tnqkr = new String[] { "수", "박" };

        for (int i = 0; i < n; i++) {
            answer += tnqkr[i % 2];
        }
        return answer;
    }
}