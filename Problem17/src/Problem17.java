/*
    Problem 17
    Found on https://projecteuler.net/problem=17
    Solution by Daniel Ginovker
    0ms solution
    Notes: This is a disgusting problem
 */

public class Problem17 {
    public static final int UPTOTWENTYVALS[] = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8, 6};
    public static final int TENS[] = {0, 3, 6, 6, 5, 5, 5, 7, 6, 6};
    public static final int HUNDRED = 7;
    public static final int THOUSAND = 8;
    public static final int AND = 3;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sum = 0;

        for (int i = 1; i <= 1000; i++)
        {
            sum += getCharCount(i);
        }

        long stop = System.currentTimeMillis();
        System.out.println("The sum of the letters from one to one thousand is " + sum);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static int getCharCount(int i)
    {
        if (i <= 19)
        {
            return UPTOTWENTYVALS[i];
        }
        if (i <= 99)
        {
            return TENS[i/10] + getCharCount(i%10);
        }
        if (i <= 999)
        {
            int notFirst = i%100;
            if (notFirst == 0)
            {
                return UPTOTWENTYVALS[i/100] + HUNDRED;
            }
            return UPTOTWENTYVALS[i/100] + (HUNDRED + AND) + getCharCount(notFirst);
            //Return (X hundred*yy) + getCharCount(yy), where YY is YY as seen in xYY
        }
        return UPTOTWENTYVALS[1] + THOUSAND;
    }
}
