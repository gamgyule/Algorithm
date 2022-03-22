package Algorithm.Programmers;

import java.math.BigInteger;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }

                }
            }
        }
        return answer;
    }

    public static boolean isPrime(int x) {
        return new BigInteger("" + x).isProbablePrime(10);
    }
}