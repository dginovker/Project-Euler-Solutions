/*
    Problem 12
    Found on https://projecteuler.net/problem=12
    Solution by Daniel Ginovker
    600ms solution
 */

public class Problem12 {
    private static final int divisorReq = 500;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        int i = 0;
        while (true)
        {
            i++;
            int triangularNum = getTriangularNum(i);
            int factors = getFactors(triangularNum);

            if (factors > divisorReq)
            {
                long stop = System.currentTimeMillis();
                System.out.println(triangularNum + " is the first triangular number with over " + divisorReq + " divisors.");
                System.out.println("Time: " + (stop - start) + "ms");
                return;
            }
        }
    }

    private static int getFactors(int n)
    {
        int facts = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n%i == 0)
            {
                facts += 2;
            }
        }
        return facts +1;
    }

    private static int getTriangularNum(int n) {
        return n*(n+1)/2; //Summation formula for summing i = 0 to n
    }
}
