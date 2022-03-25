class Solution {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt++;

            if (num % 2 == 0)
                num = num / 2;
            else if (num % 2 == 1)
                num = num - 1;
        }
        return cnt;
    }
}

// while 말고 재귀로 풀어보기
// class Solution {
//     public int numberOfSteps(int num) {
//         int count = 0;
//         return recursive(num, count);
//     }
    
//     public static int recursive(int num, int count) {
//         if (num == 0)
//             return count;

//         if (num % 2 == 0)
//             return recursive(num / 2, count + 1);

//         return recursive(num - 1, count + 1);
//     }
// }