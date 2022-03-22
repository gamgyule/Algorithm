package Algorithm.Baekjoon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baekjoon1157 {
    public static void mian(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toUpperCase();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String key : str.split("")) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        if (map.values().stream().filter(v -> v.equals(Collections.max(map.values()))).count() > 1) {
            System.out.println("?");
        } else {
            int maxValue = Collections.max(map.values());
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                if (m.getValue() == maxValue) {
                    System.out.println(m.getKey());
                    break;
                }
            }
        }
    }
}
