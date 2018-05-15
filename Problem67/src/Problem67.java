/*
    Problem 67
    Found on https://projecteuler.net/problem=67
    Solution by Daniel Ginovker
    46ms solution
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem67 {

    private static ArrayList<TriangleNode[]> triangleWeightAndVals = new ArrayList<>();


    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        loadTriangle("triangle.txt", triangleWeightAndVals);
        int mostExpensive = findMostExpensivePath(triangleWeightAndVals);

        System.out.println("The most expensive route through the triangle from top-down is " + mostExpensive);

        long stop = System.currentTimeMillis();
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static int findMostExpensivePath(ArrayList<TriangleNode[]> triangleWeightAndVals) {
        for (int i = 0; i < triangleWeightAndVals.size(); i++)
        {
            calculateLargestWeightForRow(triangleWeightAndVals.get(i));
            largestWeight(i);
        }

        return largestWeight(triangleWeightAndVals.size() - 1);
    }

    private static int largestWeight(int row) {
        int largest = 0;
        for (int i = 0; i < triangleWeightAndVals.get(row).length; i++)
        {
            if (triangleWeightAndVals.get(row)[i].weight > largest)
            {
                largest = triangleWeightAndVals.get(row)[i].weight;
            }
        }

        return largest;
    }

    private static void calculateLargestWeightForRow(TriangleNode[] triangleNodes) {
        for (TriangleNode node : triangleNodes)
        {
            if (node.getMother() != null && node.getFather() != null)
            {
                node.weight = node.hold;
                node.weight += node.getMother().weight > node.getFather().weight ? node.getMother().weight : node.getFather().weight;
            }
            else if (node.getMother() != null && node.getFather() == null)
            {
                node.weight = node.hold + node.getMother().weight;
            }
            else if (node.getMother() == null && node.getFather() != null)
            {
                node.weight = node.hold + node.getFather().weight;
            }
            else
            {
                node.weight = node.hold;
            }
        }
    }


    private static void loadTriangle(String s, ArrayList<TriangleNode[]> triangleData) {
        File data = new File(s);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(data));


            String line;
            int i = 1;
            while ((line = reader.readLine()) != null)
            {
                TriangleNode nodeArray[] = new TriangleNode[i++];
                int position = 0;
                for (int hold : Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray())
                {
                    nodeArray[position] = new TriangleNode(hold, position++, i - 2);
                }
                triangleData.add(nodeArray);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class TriangleNode {
        public int hold;
        public int weight;
        public int position;
        public int triangleDataIndex;

        public TriangleNode(int hold, int position, int triangleDataIndex)
        {
            this.hold = hold;
            this.position = position;
            this.triangleDataIndex = triangleDataIndex;
            weight = 0;
        }

        public TriangleNode getMother()
        {
            try {
                return triangleWeightAndVals.get(triangleDataIndex - 1)[position - 1];
            } catch (Exception e)
            {
                return null;
            }
        }

        public TriangleNode getFather()
        {
            try {
                return triangleWeightAndVals.get(triangleDataIndex - 1)[position];
            } catch (Exception e)
            {
                return null;
            }
        }
    }
}
