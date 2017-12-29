import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/*
    Problem 11
    Found on https://projecteuler.net/problem=11
    Solution by Daniel Ginovker
    1ms solution
 */

public class Problem11 {
    public static final int GRID_DIM = 20;
    public static void main(String[] args) throws Exception {
        int[][] grid = getGrid();
        int largest = 0;

        long start = System.currentTimeMillis();

        largest = getLargest(grid, true, false, largest);
        largest = getLargest(grid, false, true, largest);
        largest = getLargest(grid, true, true, largest);
        largest = getBottomDiag(grid, largest); //Edgecase where I have to count backwards on the row, so it can't be done in the same algorithm

        long stop = System.currentTimeMillis();
        System.out.println("Largest is " + largest);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static int getBottomDiag(int[][] grid, int oldLargest) {
        int maxRow = GRID_DIM, maxCol = GRID_DIM - 3;
        for (int col = 0; col < maxCol; col++)
        {
            for (int row = 3; row < maxRow; row++)
            {
                int product = grid[row][col] * grid[row - 1][col + 1] * grid[row - 2][col + 2] * grid[row - 3][col + 3];
                if (product > oldLargest) {
                    oldLargest = product;
                }
            }
        }
        return oldLargest;
    }

    public static int getLargest(int[][] grid, boolean incRow, boolean incCol, int oldLargest)
    {
        int maxRow = GRID_DIM, maxCol = GRID_DIM;
        if (incRow) {
            maxRow -= 3;
        }
        if (incCol) {
            maxCol -= 3;
        }
        for (int col = 0; col < maxCol; col++)
        {
            for (int row = 0; row < maxRow; row++)
            {
                int product = gridMult(grid, incRow, incCol, row, col);
                if (product > oldLargest) {
                    oldLargest = product;
                }
            }
        }
        return oldLargest;
    }

    private static int gridMult(int[][] grid, boolean incRow, boolean incCol, int row, int col) {
        int product = 1;
        for (int i = 0; i <= 3; i++)
        {
            product *= grid[row][col];
            if (incRow)
            {
                row ++;
            }
            if (incCol)
            {
                col ++;
            }
        }
        return product;
    }

    private static int[][] getGrid() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("grid.txt"));
        int[][] grid = new int[20][20];
        int gridIndex = 0;
        String line = reader.readLine();
        while (line != null)
        {
            grid[gridIndex] = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
            gridIndex ++;
            line = reader.readLine();
        }

        return grid;
    }
}
