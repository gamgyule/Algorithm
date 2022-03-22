package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < commands.length; i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(temp);
			list.add(temp[commands[i][2] - 1]);
		}
		int[] answer = list.stream().mapToInt(i -> i).toArray();
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}