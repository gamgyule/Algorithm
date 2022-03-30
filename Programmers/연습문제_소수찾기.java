package Algorithm.Programmers;

import java.util.Arrays;

// 처음에 에라토스테네스의 체를 사용했지만
// 효율성을 실패하길래 찾아보았더니
// 제곱근까지만 구하면 됐었다.
class Solution {
    public static int solution(int n) {
        int answer = 0;
        answer = eratosthenes(n);
        return answer;
    }

    public static int eratosthenes(int num) {
        int era[] = new int[num + 1];

        for (int i = 2; i <= num; i++) {
            era[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (era[i] != 0) {
                for (int j = i + i; j <= num; j += i) {
                    era[j] = 0;
                }
            }
        }
        return (int) Arrays.stream(era).filter(x -> x != 0).count();
    }
}