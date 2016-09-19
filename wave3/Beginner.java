/**
 * @author: Jenna Kwon jkwon47@gatech.edu. Email if you have any questions!
 *
 * This code is for the workshop at Georgia Tech Technical Interview Prep Club.
 * Slides pertaining to this module's code is at: http://bitly.com/gttip_fall2016_cram_session
 *
 * Problem: Count the number of ways to traverse a 2D array
 * e.g. for a 3 x 3 array, there are 6 ways. for a 5 x 5 array, there are 70 ways.
 *
 * Hint - can you come up with a combinatorial way to count the number of ways?
 *
 */

public class Beginner {

    /**
     *
     */
    public static int numberOfWays(int n, int m) {
        if (n == 0 || m == 0) { return 0; }

        return computeNumberOfWaysToXY(n - 1, m - 1, new int[n][m]);
    }

    private static int computeNumberOfWaysToXY(int x, int y, int[][] numberOfWays) {
        if (x == 0 || y == 0) {
            return 1;
        }

        if (numberOfWays[x][y] == 0) {
            int waysTop = x == 0 ? 0 : computeNumberOfWaysToXY(x - 1, y, numberOfWays);
            int waysLeft = x == 0 ? 0 : computeNumberOfWaysToXY(x, y - 1, numberOfWays);
            numberOfWays[x][y] = waysTop + waysLeft;
        }
        return numberOfWays[x][y];
    }

    public static int nChooseK(long n, long k){
        if (n < k) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return nChooseK(n - 1, k - 1) + nChooseK(n - 1, k);
    }

    public static void main(String[] args) {
        assert(numberOfWays(3, 3) == nChooseK(2, 2));
        assert(numberOfWays(4, 4) == nChooseK(3, 3));
        assert(numberOfWays(5, 5) == nChooseK(4, 4));

    }

}