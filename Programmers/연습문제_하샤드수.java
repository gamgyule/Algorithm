package Algorithm.Programmers;

class Solution {
    public boolean solution(int x) {
        String number = String.format("%d", x);
        int sum = 0;
        for (char str : number.toCharArray()) {
            sum += str - '0';
        }
        return (x % sum == 0);
    }
}