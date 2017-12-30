/*
    Problem 16
    Found on https://projecteuler.net/problem=16
    Solution by Daniel Ginovker
    11ms solution
 */


import java.math.BigInteger;

public class Problem16 {
    private static final int EXPONENT = 1000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sum = 0;
        BigInteger largePower = new BigInteger("2");
        largePower = largePower.pow(EXPONENT);

        while (!largePower.equals(new BigInteger("0")))
        {
            BigInteger remainder = largePower.mod(BigInteger.valueOf(10));
            sum += remainder.intValue();
            largePower = largePower.divide(BigInteger.valueOf(10));
        }

        long stop = System.currentTimeMillis();
        System.out.println("Sum of the digits is: " + sum);
        System.out.println("Time: " + (stop-start) + "ms");
    }
}
