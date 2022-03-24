import java.util.HashMap;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomMap = new HashMap<>();
        HashMap<Character, Integer> magMap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char a = ransomNote.charAt(i);
            ransomMap.put(a, ransomMap.getOrDefault(a, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char a = magazine.charAt(i);
            magMap.put(a, magMap.getOrDefault(a, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);

            if (ransomMap.containsKey(key) && magMap.containsKey(key)) {
                if (ransomMap.get(key) <= magMap.get(key)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

// 해시를 쓰지않고 배열로만 해보기

// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         char[] mChar = magazine.toCharArray();
//         int[] mCounter = new int[26];

//         for (int i = 0; i < mChar.length; i++) {
//             mCounter[mChar[i] - 'a']++;
//         }

//         char[] rChar = ransomNote.toCharArray();

//         for (int i = 0; i < ransomNote.length(); i++) {
//             if (mCounter[rChar[i] - 'a'] <= 0) {
//                 return false;
//             }
//             mCounter[rChar[i] - 'a']--;
//         }
//         return true;
//     }
// }