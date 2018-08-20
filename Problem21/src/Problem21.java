/*
    Problem 21
    Found on https://projecteuler.net/problem=21
    Solution by Daniel Ginovker
    292ms solution
 */


public class Problem21 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sum = 0;

        for (int i = 1; i < 10000; i++)
        {
            if (i == sumOfProperDivisors(sumOfProperDivisors(i)) && i != sumOfProperDivisors(i))
            {
                sum += i;
            }
        }

        long stop = System.currentTimeMillis();
        System.out.println("The sum of all ambicle numbers under 1000 is " + sum);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static int sumOfProperDivisors(int n)
    {
        int sum = 0;

        for (int i = 1; i <= n/2; i++)
        {
            if (n % i == 0)
            {
                sum += i;
            }
        }

        return sum;
    }
}
