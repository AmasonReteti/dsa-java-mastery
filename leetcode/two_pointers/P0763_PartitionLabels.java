package leetcode.two_pointers;

import java.util.List;
import java.util.ArrayList;

public class P0763_PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P0763_PartitionLabels solver = new P0763_PartitionLabels();
        String s = "ababcbacadefegdehijhklij";

        List<Integer> result = solver.partitionLabels(s);
        System.out.println(result);
        // Expected output: [9, 7, 8]
    }
}
