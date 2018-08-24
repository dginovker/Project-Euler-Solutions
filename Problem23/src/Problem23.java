/*
    Problem 23
    Found on https://projecteuler.net/problem=23
    Solution by Daniel Ginovker
    0ms solution
    Additional Notes: I consulted this resource for debugging assistance - https://oeis.org/A048242
 */


import java.util.ArrayList;

public class Problem23 {

    private static int MAX_ABUNDANT = 28123; //28123 is the smallest number that can possibly not be written as the sum of two other abundant numbers
    private static ArrayList<Integer> abundantNumbers = new ArrayList<>();
        
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sumOfNonAbundantPairs = 0;
        fillAbundantNumbers();

        for (int i = 1; i < MAX_ABUNDANT; i++)
        {
           if (!canBeWrittenAsSum(i))
           {
               sumOfNonAbundantPairs += i;
           }
        }


        long stop = System.currentTimeMillis();
        System.out.println("The sum of all positive integers that cannot be written as the sum of two abundant numbers is: " + sumOfNonAbundantPairs);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static boolean canBeWrittenAsSum(int i) {
        for (int j = 0; j < abundantNumbers.size(); j++) {
            for (int k = 0; k <= j; k++) {
               if (abundantNumbers.get(j) + abundantNumbers.get(k) == i)
               {
                   return true;
               }
               else if (abundantNumbers.get(j) + abundantNumbers.get(k) >= i)
               {
                   k = j+1;
               }
            }
        }

        return false;
    }

    private static void fillAbundantNumbers() {
        int sum;

        for (int i = 1; i < MAX_ABUNDANT; i++) {
            sum = 0;
            for (int j = 1; j <= i/2; j++) { //TODO - Efficiency, j <= sqrt(j), if i%j = 0 then sum+=j+i/j
               if (i % j == 0)
               {
                   sum += j;
               }
            }

            if (sum > i)
            {
                abundantNumbers.add(i);
            }
        }
    }
}
