/*
    Problem 23
    Found on https://projecteuler.net/problem=23
    Solution by Daniel Ginovker
    339ms solution
    Additional Notes:
        - I consulted this resource for debugging assistance - https://oeis.org/A048242
        - The previous solution contained a "TODO" with an efficiency suggestion that contained a broken equation
        - Pre-optimization the algorithm ran in 273,807ms
 */


import java.util.ArrayList;
import java.util.Arrays;

public class Problem23 {

    private static int MAX_NON_ABUNDANT = 28123; //28123 is the smallest number that can possibly not be written as the sum of two other abundant numbers
    private static ArrayList<Integer> abundantNumbers = new ArrayList<>();
    private static Integer[] abundantSums = new Integer[MAX_NON_ABUNDANT];

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sumOfNonAbundantPairs = 0;
        fillAbundantNumbers(); //nlog(n) (reduced from n^2)
        fillAbundantSums(); //n^2 + nlog(n) (added)

        for (int i = 1; i < MAX_NON_ABUNDANT; i++) //log(n) (reduced from n^3)
        {
            if (Arrays.binarySearch(abundantSums, i) < 0)
            {
                sumOfNonAbundantPairs += i;
            }
        }

        long stop = System.currentTimeMillis();
        System.out.println("The sum of all positive integers that cannot be written as the sum of two abundant numbers is: " + sumOfNonAbundantPairs);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static void fillAbundantSums() {
        for (int i = 0; i < abundantSums.length; i++) {
            abundantSums[i] = 0;
        }

        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = 0; j <= i; j++) {
                int slot = abundantNumbers.get(i) + abundantNumbers.get(j);
                if (slot > MAX_NON_ABUNDANT)
                {
                    j = i+1;
                }
                else
                {
                    abundantSums[slot - 1] = slot;
                }
            }
        }

        Arrays.sort(abundantSums);
    }

    private static void fillAbundantNumbers() {
        int sum;

        for (int i = 2; i < MAX_NON_ABUNDANT; i++) {
            sum = 0;
            for (int j = 2; j <= Math.sqrt(i); j++) //20,000ms saved here
            {
                if (i % j == 0)
                {
                    sum += j + i/j;
                    if (j*j == i) //VERY important to make sure you don't double-count perfect squares
                    {
                        sum -= j;
                    }
                }
            }

            if (sum + 1 > i) //Sum +1 since we started at j=2
            {
                abundantNumbers.add(i);
            }
        }
    }
}
