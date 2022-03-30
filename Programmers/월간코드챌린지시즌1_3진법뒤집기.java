package Algorithm.Programmers;

class Solution {
    public static int solution(int n) {
        three(n);
        int sum = Integer.parseInt(thNum, 3);
        return sum;
    }

    static String thNum = "";

    public static void three(int num) {
        if (num <= 0)
            return;
        thNum += num % 3;
        three(num / 3);
    }
}