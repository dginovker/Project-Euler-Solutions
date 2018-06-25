/*
    Problem 20
    Found on https://projecteuler.net/problem=X
    Solution by Daniel Ginovker
    3ms solution
 */


import java.math.BigInteger;

public class Problem20 {
    public static void main(String[] args) {
        int sum = 0;

        long start = System.currentTimeMillis();

        BigInteger main = getFactorial(100);

        while (!main.equals(new BigInteger("0")))
        {
            sum += main.mod(new BigInteger("10")).intValue();
            main = main.divide(new BigInteger("10"));
        }

        long stop = System.currentTimeMillis();
        System.out.println("The sum of the digits in 100! is " + sum);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static BigInteger getFactorial(int end) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= end; i++)
        {
            fact = fact.multiply(new BigInteger(i + ""));
        }

        return fact;
    }
}
