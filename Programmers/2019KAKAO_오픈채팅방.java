import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static class Info {

        Info(String type, String uuid) {
            this.type = type;
            this.uuid = uuid;
        }

        String type;
        String uuid;
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> map = new HashMap<>();
        ArrayList<Info> asd = new ArrayList<Info>();

        int length = 0;
        for (int i = 0; i < record.length; i++) {
            String[] content = record[i].split(" ");
            asd.add(new Info(content[0], content[1]));
            if (content[0].equals("Enter") || content[0].equals("Change")) {
                map.put(content[1], content[2]);
            }

            if (content[0].equals("Enter") || content[0].equals("Leave")) {
                length++;
            }
        }
        System.out.println(length);
        int index = 0;
        answer = new String[length];
        for (Info info : asd) {
            if (info.type.equals("Enter")) {
                answer[index] = map.get(info.uuid) + "님이 들어왔습니다.";
                index++;
            } else if (info.type.equals("Leave")) {
                answer[index] = map.get(info.uuid) + "님이 나갔습니다.";
                index++;
            }
        }
        return answer;
    }

}