/*
    Problem 19
    Found on https://projecteuler.net/problem=19
    Solution by Daniel Ginovker
    0ms solution
 */


public class Problem19 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int sun = 0;
        int day = 2; //January 1st, 1901 was a Tuesday

        for (int year = 1901; year <= 2000; year++)
        {
            for (int month = 0; month < 12; month++)
            {
                sun += day % 7 == 0 ? 1 : 0;
                day += getDays(month, year);
            }
        }

        long stop = System.currentTimeMillis();
        System.out.println("The number of Sundays that fell on the first of the month during the 21st century was " + sun);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    public static int getDays(int month, int year)
    {
        switch (month)
        {
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            case 1:
                if (year % 4 == 0)
                {
                    return year % 100 == 0 ? year % 400 == 0 ? 29 : 28 : 29;
                }
                return 28;
            default:
                return 31;
        }
    }
}
