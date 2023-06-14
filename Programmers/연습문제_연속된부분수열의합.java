import java.util.Arrays;

public class Main {

    static int[] prefixSum;
    static int[] minArr;
    static int minLength = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5 }, 7)));
    }

    public static int[] solution(int[] sequence, int k) {
        int head = 0;
        int tail = 0;
        prefixSum = new int[sequence.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + sequence[i - 1];
        }
        while (tail <= sequence.length && head <= sequence.length) {
            int tempSum = prefixSum[tail] - prefixSum[head];
            if (tempSum == k) {
                if ((tail - head) + 1 < minLength) {
                    minLength = (tail - head) + 1;
                    minArr = new int[] { head, tail - 1 };
                }
                tail++;
            } else if (tempSum > k) {
                head++;
            } else {
                tail++;
            }
        }
        return minArr;
    }
}