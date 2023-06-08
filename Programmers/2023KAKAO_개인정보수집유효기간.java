import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (String privacy : privacies) {
            cnt++;

            String[] day = today.split("\\.");
            int todayYear = Integer.parseInt(day[0]);
            int todayMonth = Integer.parseInt(day[1]);
            int todayDay = Integer.parseInt(day[2]);

            String[] pri = privacy.split(" ")[0].split("\\.");
            int priYear = Integer.parseInt(pri[0]);
            int priMonth = Integer.parseInt(pri[1]);
            int priDay = Integer.parseInt(pri[2]);

            int termDate = Arrays.asList(terms).stream()
                    .filter(str -> str.charAt(0) == privacy.charAt(privacy.length() - 1))
                    .map(str -> Integer.parseInt(str.split(" ")[1]))
                    .findFirst().orElse(null);

            int expiredMonth = priMonth + termDate;
            int expiredYear = priYear;
            int expiredDay = priDay - 1;
            if (expiredMonth > 12) {
                expiredYear += expiredMonth / 12;
                expiredMonth = expiredMonth % 12;
            }

            if (expiredDay < 1) {
                expiredDay = 28;
                expiredMonth--;
            }
            
            if (expiredMonth < 1) {
                expiredYear--;
                expiredMonth = 12;
            }

            System.out.println(expiredYear + "." + expiredMonth + "." + expiredDay);

            if (expiredYear > todayYear) {
                continue;
            } else if (expiredYear < todayYear) {
                list.add(cnt);
                continue;
            } else {
                if (expiredMonth > todayMonth) {
                    continue;
                } else if (expiredMonth < todayMonth) {
                    list.add(cnt);
                    continue;
                } else {
                    if (expiredDay >= todayDay) {
                        continue;
                    } else if (expiredDay < todayDay) {
                        list.add(cnt);
                        continue;
                    }
                }
            }

        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}