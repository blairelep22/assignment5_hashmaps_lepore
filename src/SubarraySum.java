
/*

LOGIC :)
I created an array prefix of size A.length + 1 to store the cumulative sum of elements up to each index.
The prefix[i] represents the sum of elements from index 0 to i-1 .

Then I found the subarray:
Iterate through the array A.
For each element A[i], find targetSum
If targetSum falls in range (0 to prefix.length - 1),
            check if prefix[targetSum] is not zero.

Time and Space Complexity:
Time complexity: O(n) : iterating through the array once for prefix sum calculation and another time for finding the subarray.
Space complexity: O(1) because fixed-size array prefix regardless of the input size.

 */
public class SubarraySum {

    public static int[] sumTarget(int[] A, int K) {
        int[] prefix = new int[A.length + 1]; // 1 extra element for handling empty subarray
        prefix[0] = 0; //Initialize prefix sum for empty subarray


        for (int i = 1; i < prefix.length; i++) {   // Calculate prefix sum for each index
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        //subarray get
        for (int i = 0; i < A.length; i++) {
            int targetSum = prefix[i] - K; // target sum
            if (targetSum >= 0) {
                for (int j = 0; j < i; j++) {
                    if (prefix[j] == targetSum) {
                        return new int[]{j, i - 1};
                    }
                }
            }
        }

        return new int[]{-1, -1}; //when No subarray found
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 7, 5};
        int K = 11;
        int[] result = sumTarget(A, K);
        System.out.println("Start: " + result[0] + ", End: " + result[1]);
    }
}

