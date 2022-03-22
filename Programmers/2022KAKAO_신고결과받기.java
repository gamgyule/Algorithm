package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public static class Report {
        String a;
        ArrayList<String> b = new ArrayList<>();
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        ArrayList<String> arr = (ArrayList<String>) Stream.of(report).distinct().collect(Collectors.toList());
        String[] distReport = arr.toArray(new String[arr.size()]);

        ArrayList<Report> rep = new ArrayList<>();
        for (String str : id_list) {
            Report re = new Report();
            re.a = str;
            rep.add(re);
        }

        for (String str : distReport) {
            String[] dstr = str.split(" ");
            rep.get(Arrays.asList(id_list).indexOf(dstr[0])).b.add(dstr[1]);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : distReport) {
            map.put(str.split(" ")[1], map.getOrDefault(str.split(" ")[1], 0) + 1);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < rep.size(); i++) {
            for (String str : rep.get(i).b) {
                if (map.containsKey(str)) {
                    if (map.get(str).intValue() >= k) {
                        answer[i] += 1;
                    }
                }
            }
        }
        return answer;
    }
}