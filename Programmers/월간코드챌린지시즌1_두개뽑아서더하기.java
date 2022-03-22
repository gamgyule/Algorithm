package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] numbers) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				list.add(numbers[i] + numbers[j]);
			}
		}

		answer = list.stream().distinct().mapToInt(Integer::intValue).toArray();
		Arrays.sort(answer);
		return answer;
	}
}