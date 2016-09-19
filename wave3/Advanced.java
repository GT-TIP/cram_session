/**
 * @author: Jenna Kwon jkwon47@gatech.edu. Email if you have any questions!
 *
 * This code is for the workshop at Georgia Tech Technical Interview Prep Club.
 * Slides pertaining to this module's code is at: http://bitly.com/gttip_fall2016_cram_session
 *
 * Problem
 * Given a circular array, compute its maximum subarray sum.
 *
 * Approach
 * Solution 1: O(n^2)
 * - Compute maximum subarray for all endpoints (there are n^2 end poitns) & pick the best one
 *
 * Solution 2: O(n)
 * - Two cases:
 * - 1) Maximum subarray is contained within the "most minimum subarray"
 * - 2) Maximum subarray is contained outside the "most minimum subarray"
 * - Return the max between sum - most minimum subarray or most maximum subarray
 *
 */

public class Advanced {
    // @include
    /**
     * Implementation of Solution 1
     * @param arr
     * @return
     */
    public static int maxSubSumBruteForce(int[] arr) {
        int maxGlobal = 0;

        for (int i = 0; i < arr.length; i++) {
            int maxCurrent = 0;

            for (int j = i; j < i + arr.length; j++) {
                maxCurrent += arr[j % arr.length];
                if (maxCurrent < 0) {
                    maxCurrent = 0;
                }
                if (maxGlobal < maxCurrent) {
                    maxGlobal = maxCurrent;
                }
            }
        }
        return maxGlobal;
    }

    /**
     * Implementation of Solution 2
     * @param arr
     */
    public static int maxSubsum(int[] arr) {
        int minInArray = 0;
        int maxInArray = 0;
        int minSoFar = minInArray;
        int maxSoFar = maxInArray;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            minSoFar += arr[i];
            maxSoFar += arr[i];

            if (minSoFar > 0) {
                minSoFar = 0;
            }

            if (maxSoFar < 0) {
                maxSoFar = 0;
            }

            if (minInArray > minSoFar) {
                minInArray = minSoFar;
            }

            if (maxInArray < maxSoFar) {
                maxInArray = maxSoFar;
            }
        }

        return Math.max(sum - minInArray, maxInArray);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, 4, -1, -2, 1, 5, 0, -18, -15, 6, 7, -20, 12};
        System.out.println(maxSubSumBruteForce(arr));
        System.out.println(maxSubsum(arr));

        int[] arr2 = {2, -8, 3, -2, 4, -10};
        System.out.println(maxSubSumBruteForce(arr2));
        System.out.println(maxSubsum(arr2));
    }
}