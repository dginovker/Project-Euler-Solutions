import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Problem11 {
    public static final int GRID_DIM = 20;
    public static void main(String[] args) throws Exception {
        int[][] grid = getGrid();
        int largest = 0;

        largest = getLargest(grid, true, false, largest);
        largest = getLargest(grid, false, true, largest);
        largest = getLargest(grid, true, true, largest);

        System.out.println("Largest is " + largest);
    }

    public static int getLargest(int[][] grid, boolean incRow, boolean incCol, int oldLargest)
    {
        int largest = 0, maxRow = GRID_DIM, maxCol = GRID_DIM;
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
                if (product > largest) {
                    System.out.println("Set largest (" + largest + ") to " + product);
                    largest = product;
                }
            }
        }
        if (oldLargest > largest)
        {
            return oldLargest;
        }
        return largest;
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
        System.out.println("got " + product);
        return product;
    }

    private static int[][] getGrid() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("Project11/src/grid.txt"));
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
