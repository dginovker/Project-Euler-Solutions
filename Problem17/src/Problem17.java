/*
    Problem 17
    Found on https://projecteuler.net/problem=17-
    Solution by Daniel Ginovker
    0ms solution
 */


public class Problem17 {
    public static final int UPTOTWENTYVALS[] = {4, 3, 3, 5, 4, 3, 5, 5, 4, 6, 6, 8, 8, 7, 7, 9, 8, 8, 6};
    public static final int TENS[] = {3, 6, 6, 5, 5, 5, 7, 7, 6};
    public static final int ONE = 3, TWO = 3, THREE = 5, FOUR = 4, FIVE = 4, SIX = 3, SEVEN = 5, EIGHT = 5, NINE = 4;
    public static final int ONETONINE = 36;
    public static final int TENTONINETEEN = 73;//3 + eleven 6 + twelve 6 + thirteen 8 + fourteen 8 + fifteen 7 + sixteen 7 + seventeen 9 + eighteen 8 + 8
    public static final int TWENTY = 6, THIRTY = 6, FORTY = 5, FIFTY = 5;
    public static final int HUNDRED = 7;
    public static final int THOUSAND = 8;
    public static final int AND = 3;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sum = 0;

        int oneToNineteen = ONETONINE + TENTONINETEEN;
        int twentyToNinetynine = (TWENTY + THIRTY + FORTY + FIFTY + (SIX + SEVEN + EIGHT + NINE + 4*2))*10 + 8*ONETONINE;
        int oneToNinetynine = oneToNineteen + twentyToNinetynine;

        int hundreds = ONETONINE + HUNDRED*9;

        sum += oneToNinetynine; //1 - 99
        sum += ((HUNDRED + AND)*99 + oneToNinetynine)*9; //101 - 999. hundreds not included
        sum += hundreds; //hundreds
        sum += ONE + THOUSAND;//thousand

        long stop = System.currentTimeMillis();
        System.out.println("The sum of the letters from one to one thousand is " + sum);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    int getCharCount(int i)
    {
        if (i <= 9)
        {
            return UPTOTWENTYVALS[i];
        }
        if (i <= 99)
        {
            return TENS[i/10] + getCharCount(i%10);
        }
        if (i <= 999)
        {
            return 
        }
    }
}
