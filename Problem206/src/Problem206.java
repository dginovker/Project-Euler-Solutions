/*
    Problem 206
    Found on https://projecteuler.net/problem=206
    Solution by Daniel Ginovker
    0ms solution
    Notes: This is just an ambitious attempt at a high level problem, because I figured I knew an efficient solution
 */


import java.math.BigInteger;

public class Problem206 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long begin = (long) Math.floor(Math.sqrt(1020304050607080900d));
        long end = (long) Math.ceil(Math.sqrt(1929394959697989990d));

        System.out.println(new BigInteger(String.valueOf(end)).pow(2));
        Double answer = null;

/*        for (int i = (int) end; i > begin; i--)
        {
/*            if (matches(Math.pow(i, 2)))
            {
                i = (int) end;
                answer = new Double(Math.pow(i, 2));
            }
  *//*
            System.out.println("for i: " + i + " - " + new Double(Math.pow(i,2)).toString());
            if (new Double(Math.pow(i, 2)).toString().matches("..............8.9.0"))
            {
                i = (int) end;
                answer = new Double(Math.pow(i, 2));
                //Unique positive integer is: 1.92939495123976224E17
                //Time: 1507ms
            }

        }

        long stop = System.currentTimeMillis();
        System.out.println("Unique positive integer is: " + answer);
        System.out.println("Time: " + (stop-start) + "ms");
*/    }

    private static boolean matches(double pow) {
        long l = (long) pow;

        if (l % 10 != 0)
        {
            return false;
        }
        l/=100;

        for (int i = 9; i >= 1; i--)
        {
            if (l % 10 != i)
            {
                return false;
            }
            l/=100;
        }
        return true;
    }
}
