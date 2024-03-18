import java.util.*;

public class RadixSort {

    public static void radixSort(String[] arr) {
        final int letters = 52;
        List<String>[] buckets = new LinkedList[letters];
        for (int i = 0; i < letters; i++) {
            buckets[i] = new LinkedList<>();
        }

        // Find the maximum length of strings
        int maxLength = 0;
        for (int k = 0; k < arr.length; k++) {
            maxLength = Math.max(maxLength, arr[k].length());
        }

        // Apply counting sort for each character from right to left
        for (int digit = maxLength - 1; digit >= 0; digit--) {
            for (int j = 0; j < arr.length; j++) {
                String s = arr[j];
                int index;
                if (digit < s.length()) {
                    char ch = s.charAt(digit);
                    if (Character.isLowerCase(ch)) {
                        index = ch - 'a';
                    } else {
                        index = ch - 'A' + 26;
                    }
                } else {
                    index = 0; // if the string length is smaller than digit
                }
                buckets[index].add(s);
            }

            int i = 0;
            for (int bucketIndex = 0; bucketIndex < letters; bucketIndex++) {
                List<String> bucket = buckets[bucketIndex];
                for (int k = 0; k < bucket.size(); k++) {
                    arr[i++] = bucket.get(k);
                }
                bucket.clear();
            }
        }
    }

    public static void main(String[] args) {
        String[] input = {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman", "hydra", "surtr"};
        radixSort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
    }

}