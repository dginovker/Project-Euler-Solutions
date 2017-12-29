/*
    Problem 14
    Found on https://projecteuler.net/problem=14
    Solution by Daniel Ginovker
    83ms solution
 */

import java.util.HashMap;

public class Problem14 {

    public static final int MAX = 1000000;

    private static long[] values = null;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        values = new long[MAX];
        long longestPath = 0;
        int startingNumber = 0;

        for (int i = 1; i < MAX; i++)
        {
            values[i] = getChain(i);
            if (values[i] > longestPath)
            {
                longestPath = values[i];
                startingNumber = i;
            }
        }

        long stop = System.currentTimeMillis();
        System.out.println("Longest path: " + longestPath + ", made by: " + startingNumber);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static long getChain(long orign) { //74ms for 100k
        long length = 1;
        long n = orign;

        while (n != 1)
        {
            length++;
            if (n < orign)
            {
                return values[(int) n] + length;
            }
            if (n%2 == 0)
            {
                n = n/2;
                continue;
            }
            n = 3*n +1;
        }

        return length;
    }
}
