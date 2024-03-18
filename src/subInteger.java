

import java.util.HashMap;
import java.util.Map;


public class subInteger {
        public static String isSubset(int[] S, int[] T) {
            Map<Integer, Integer> map = new HashMap<>();

            // Add elements of T to the map
            for (int num : T) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // Check if every element in S is in T
            for (int num : S) {
                if (!map.containsKey(num) || map.get(num) == 0) {
                    return "No";
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }

            return "Yes";
        }

        public static void main(String[] args) {
            int[] S1 = {32, 3};
            int[] T1 = {1, 2, 3, 52, 32, 54};
            System.out.println(isSubset(S1, T1)); // Yes

            int[] S2 = {89, 32, 54, 32, 3};
            int[] T2 = {54, 32, 99};
            System.out.println(isSubset(S2, T2)); // No

            int[] S3 = {0, 67};
            int[] T3 = {100, 5, 66, 2, 32, 90};
            System.out.println(isSubset(S3, T3)); // No

            int[] S4 = {};
            int[] T4 = {54, 32, 99};
            System.out.println(isSubset(S4, T4)); // Yes
        }
    }


