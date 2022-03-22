package Algorithm.Programmers;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String prefix = phone_number.substring(0, phone_number.length() - 4);
        int cnt = prefix.length();
        String suffix = phone_number.substring(phone_number.length() - 4, phone_number.length());
        answer = "*".repeat(cnt) + suffix;
        return answer;
    }
}