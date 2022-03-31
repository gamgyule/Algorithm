class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int yCount = 0;
        int pCount = 0;
        s = s.toLowerCase();
        yCount = (int) new String(s.toCharArray()).chars().filter(x -> x == 'y').count();
        pCount = (int) new String(s.toCharArray()).chars().filter(x -> x == 'p').count();
        if (yCount != pCount)
            answer = false;
        return answer;
    }
}