class Solution {
    public String solution(String s) {
        String answer = "";

        String[] spl = s.split(" ");
        for (String str : spl) {
            if (str.equals(" ") || str.length() < 1) {
                answer += " ";
                continue;
            }
            String prefix = str.substring(0, 1).toUpperCase();
            String suffix = str.substring(1, str.length()).toLowerCase();
            answer += prefix + suffix + " ";

        }
        answer = answer.trim();
        if (s.subSequence(s.length() - 1, s.length()).equals(" ")) {
            answer += " ";
        }
        return answer;
    }
}