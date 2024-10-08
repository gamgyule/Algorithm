import java.util.*;

public class Main {

    public static Queue<int[]> queue = new LinkedList<>();
    public static Map<String, Integer> historyMap = new HashMap<>();

    public static void main(String[] args) {

        // case 1
        // System.out.println(solution(new int[][] { { 3, 2 }, { 6, 4 }, { 4, 7 }, { 1,
        // 4 } },
        // new int[][] { { 4, 2 }, { 1, 3 }, { 2, 4 } }));

        // case 2
        // System.out.println(solution(new int[][] { { 3, 2 }, { 6, 4 }, { 4, 7 }, { 1,
        // 4
        // } }, new int[][] { { 4, 2 }, { 1, 3 }, { 4, 2 }, { 4, 3 } }));

        // case 3
        // System.out.println(solution(new int[][] { { 2, 2 }, { 2, 3 }, { 2, 7 }, { 6,6
        // }, { 5, 2 } },new int[][] { { 2, 3, 4, 5 }, { 1, 3, 4, 5 } }));

    }

    public static int solution(int[][] points, int[][] routes) {
        int answer = 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int pointIndex = routes[i][j] - 1;
                System.out.println(pointIndex);
                System.out.println(Arrays.toString(points[pointIndex]));
                queue.add(new int[] { points[pointIndex][0], points[pointIndex][1] });
            }

            int[] startPoint = queue.poll();
            int time = 1;
            String key = time + "_" + startPoint[0] + "_" + startPoint[1];
            historyMap.put(key, historyMap.getOrDefault(key, 0) + 1);
            time++;
            while (!queue.isEmpty()) {
                int[] nextPoint = queue.poll();
                System.out.println(startPoint[0] + "_" + startPoint[1]);
                // 행 이동
                if (startPoint[0] < nextPoint[0]) {
                    while (startPoint[0] < nextPoint[0]) {
                        startPoint[0]++;
                        key = time + "_" + startPoint[0] + "_" + startPoint[1];
                        historyMap.put(key, historyMap.getOrDefault(key, 0) + 1);
                        time++;
                        System.out.println(
                                "PATH: " + Arrays.toString(startPoint) + ", END: " + Arrays.toString(nextPoint));

                    }
                } else {
                    while (startPoint[0] > nextPoint[0]) {
                        startPoint[0]--;
                        key = time + "_" + startPoint[0] + "_" + startPoint[1];
                        historyMap.put(key, historyMap.getOrDefault(key, 0) + 1);
                        time++;
                        System.out.println(
                                "PATH: " + Arrays.toString(startPoint) + ", END: " + Arrays.toString(nextPoint));

                    }
                }

                // 열 이동
                if (startPoint[1] < nextPoint[1]) {
                    while (startPoint[1] < nextPoint[1]) {
                        startPoint[1]++;
                        key = time + "_" + startPoint[0] + "_" + startPoint[1];
                        historyMap.put(key, historyMap.getOrDefault(key, 0) + 1);
                        time++;
                        System.out.println(
                                "PATH: " + Arrays.toString(startPoint) + ", END: " + Arrays.toString(nextPoint));
                    }
                } else {
                    while (startPoint[1] > nextPoint[1]) {
                        startPoint[1]--;
                        key = time + "_" + startPoint[0] + "_" + startPoint[1];
                        historyMap.put(key, historyMap.getOrDefault(key, 0) + 1);
                        time++;
                        System.out.println(
                                "PATH: " + Arrays.toString(startPoint) + ", END: " + Arrays.toString(nextPoint));
                    }
                }
                System.out.println(
                        "------------ START: " + Arrays.toString(startPoint) + ", END: " + Arrays.toString(nextPoint));
            }
            System.out.println("#######################################################");
        }

        answer = (int) historyMap.values().stream().filter(item -> item > 1).count();
        return answer;
    }
}
