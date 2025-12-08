package neet.blind75;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length() + "#" + str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String s) {
        List<String> decodedString = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, j));
            String str = s.substring(j + 1, j + 1 + length);
            decodedString.add(str);
            i = j + 1 + length;
        }
        return decodedString;
    }

    public static void main(String[] args) {
        String[] input = {"neet", "code", "love", "you"};
        EncodeAndDecodeString encodeAndDecodeString = new EncodeAndDecodeString();
        String encodedString = encodeAndDecodeString.encode(List.of(input));
        System.out.println("Encoded String: " + encodedString);
        List<String> decodedString = encodeAndDecodeString.decode(encodedString);
        System.out.println("Decoded Strings: " + decodedString);
    }
}
