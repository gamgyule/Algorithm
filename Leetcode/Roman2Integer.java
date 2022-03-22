class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int res = 0;
            if ((i + 1) < s.length()) {
                char t = s.charAt(i + 1);
                String hn = Character.toString(c) + Character.toString(t);
                if (map.containsKey(hn)) {
                    res = map.get(hn);
                    sum += res;
                    i++;
                    continue;
                }
            }
            res = map.get(c + "");
            sum += res;
        }
        return sum;
    }
}




// public static int romanToInt(String s) {
    //     Map<String, Integer> map = new HashMap<>();
    //     map.put("I", 1);
    //     map.put("V", 5);
    //     map.put("X", 10);
    //     map.put("L", 50);
    //     map.put("C", 100);
    //     map.put("D", 500);
    //     map.put("M", 1000);

    //     int sum = 0;
    //     int prev = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         char hc = s.charAt(i);
    //         int here = map.get(hc + "");
    //         if (here > prev) {
    //             sum -= prev;
    //             sum += (here - prev);
    //         } else {
    //             sum += here;
    //         }

    //         prev = here;
    //     }
    //     return sum;
    // }



