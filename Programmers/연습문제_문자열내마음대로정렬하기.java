class Solution {
    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].charAt(n) > strings[j].charAt(n)) {
                    String min = strings[j];
                    strings[j] = strings[i];
                    strings[i] = min;
                } else if (strings[i].charAt(n) == strings[j].charAt(n)) {
                    if (strings[i].compareTo(strings[j]) > 0) {
                        String min = strings[j];
                        strings[j] = strings[i];
                        strings[i] = min;
                    }
                }
            }
        }
        return strings;
    }
}