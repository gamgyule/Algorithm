package Algorithm.Programmers;

import java.util.Arrays;

class Solution {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		float[][] failedPer = new float[N][2];

		for (int i = 1; i <= N; i++) {
			int idx = i;
			float play = (int) Arrays.stream(stages).filter(x -> x >= idx).count();
			float failed = (int) Arrays.stream(stages).filter(x -> x >= idx).filter(y -> y <= idx).count();
			failedPer[i - 1][0] = (failed / play);
			if (failed + play == 0)
				failedPer[i - 1][0] = 0;
			failedPer[i - 1][1] = i;
		}

		Arrays.sort(failedPer, (o1, o2) -> Float.compare(o2[0], o1[0]));

		for (int i = 0; i < failedPer.length; i++) {
			answer[i] = (int) failedPer[i][1];
		}
		return answer;
	}
}