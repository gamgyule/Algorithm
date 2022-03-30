package Algorithm.Programmers;

class Solution {
    public int solution(String s) {
        int a = (s.charAt(0) == '+') ? Integer.parseInt(s.substring(1))
                : (s.charAt(0) == '-') ? Integer.parseInt(s.substring(1)) * -1 : Integer.parseInt(s);
        return a;
    }
}