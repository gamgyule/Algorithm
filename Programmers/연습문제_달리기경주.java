package Algorithm.Programmers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> playerList = Arrays.asList(players);
        Map<String, Integer> order = new HashMap();
        for (int i = 1; i <= playerList.size(); i++) {
            order.put(playerList.get(i - 1), i - 1);
        }
        for (String call : callings) {
            int index = order.get(call);
            String temp = playerList.get(index - 1);
            playerList.set(index - 1, playerList.get(index));
            playerList.set(index, temp);

            order.put(call, order.get(call) - 1);
            order.put(temp, order.get(temp) + 1);
        }
        return playerList.toArray(new String[0]);
    }
}