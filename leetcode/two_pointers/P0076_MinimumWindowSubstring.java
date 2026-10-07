package leetcode.two_pointers;

import java.util.Map;
import java.util.HashMap;

public class P0076_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> required = new HashMap<>();

        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        int requiredCharsRemaining = required.size();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCounts.put(rightChar, windowCounts.getOrDefault(rightChar, 0) + 1);

            if (required.containsKey(rightChar) && windowCounts.get(rightChar).intValue() == required.get(rightChar).intValue()) {
                requiredCharsRemaining--;
            }

            while (requiredCharsRemaining == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);

                if (required.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < required.get(leftChar).intValue()) {
                    requiredCharsRemaining++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        P0076_MinimumWindowSubstring solver = new P0076_MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(solver.minWindow(s, t));
        // Expected output: BANC
    }
}
