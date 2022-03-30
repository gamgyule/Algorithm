package Algorithm.Programmers;

import java.util.Arrays;
class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        int size = Arrays.stream(nums).distinct().toArray().length;

        return (size > max) ? max : size;
    }
}