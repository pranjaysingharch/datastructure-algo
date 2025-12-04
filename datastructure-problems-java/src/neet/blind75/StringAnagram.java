package neet.blind75;

import java.util.HashMap;
import java.util.Map;

public class StringAnagram {
    public boolean isAnagramWith2HashMap(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {

            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sMap.equals(tMap);

    }
    public boolean isAnagramWith1HashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();

        // 1. Build map for String S
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        // 2. Process String T
        for (char c : t.toCharArray()) {
            // FAIL FAST: If t has a char that s doesn't have, stop immediately
            if (!sMap.containsKey(c)) {
                return false;
            }

            // Decrement count
            int count = sMap.get(c);
            if (count == 1) {
                sMap.remove(c);
            } else {
                sMap.put(c, count - 1);
            }
        }

        return true; // If we finish the loop, it's a match
    }
    public boolean isAnagramWithArray(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c-'a']++;
        }
        for (char c : t.toCharArray()){
            count[c-'a']--;
        }
        for (int i : count){
            if (i != 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        StringAnagram sa = new StringAnagram();
        System.out.println(sa.isAnagramWithArray("anagram", "nagaram")); // true
        System.out.println(sa.isAnagramWithArray("rat", "tar")); // false
        }
}



