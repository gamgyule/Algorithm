package Algorithm.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -99;
                    reserve[j] = -99;
                    break;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (Math.abs(lost[i] - reserve[j]) == 1) {
                    lost[i] = -99;
                    reserve[j] = -99;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}