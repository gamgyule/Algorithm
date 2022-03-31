//문자열로 처리하다보니 속도가 느려서 알아보니
// %와/로 문제를 풀 수 있었다
// class Solution {
//     public boolean isPalindrome(int x) {
//         int origin = x;
//         int temp = 0;
//         while (x > 0) {
//             temp = temp * 10 + x % 10;
//             x = x / 10;
//         }
//         if (origin != temp)
//             return false;
//         return true;
//     }
// }
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String str = x + "";

        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - '0';
            temp += c;
        }

        for (int i = 0; i < temp.length() / 2; i++) {
            int left = temp.charAt(i) - '0';
            int right = temp.charAt(temp.length() - i - 1) - '0';
            if (left != right)
                return false;
        }
        return true;
    }
}