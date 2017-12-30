/*
    Problem 15
    Found on https://projecteuler.net/problem=15
    Solution by Daniel Ginovker
    0ms solution
 */


public class Problem15 {

    public static int GRID_DIM = 20;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        double waysToMove = 1;
        double lengthRestriction = 1;
        for (int i = 2; i <= GRID_DIM*2; i++)
        {
            waysToMove *= i;
            if (i <= GRID_DIM)
            {
                lengthRestriction*=i;
            }
        }
        lengthRestriction *= lengthRestriction;

        double paths = waysToMove/lengthRestriction;

        long stop = System.currentTimeMillis();
        System.out.println("The number of paths through the grid is: " + paths);
        System.out.println("Time: " + (stop-start) + "ms");
    }
}
