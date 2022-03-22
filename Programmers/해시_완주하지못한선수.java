package Algorithm.Programmers;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();

		for (String person : participant)
			map.put(person, map.getOrDefault(person, 0) + 1);
		for (String person : completion)
			map.put(person, map.get(person) - 1);

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				answer = entry.getKey();
			}
		}

		return answer;
	}
}