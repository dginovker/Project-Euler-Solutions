/*
    Problem 22
    Found on https://projecteuler.net/problem=22
    Solution by Daniel Ginovker
    92ms solution
 */


import java.io.*;
import java.util.ArrayList;

import static java.util.Collections.sort;

public class Problem22 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        ArrayList<String> names = new ArrayList<>();
        BufferedReader buffReader = new BufferedReader(new FileReader("names.txt"));

        String line = buffReader.readLine();

        for (String i : line.split(","))
        {
            names.add(i);
        }

        sort(names);

        int sum = 0;
        for (int i = 0; i < names.size(); i++)
        {
            sum += weight(names.get(i)) * (i + 1);
        }

        long stop = System.currentTimeMillis();
        System.out.println("The total score of the list is " + sum + ".");
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static int weight(String s) {
        int sum = 0;

        for (Byte b : s.getBytes())
        {
            if (b == 32 || b == 34)
            {
                continue;
            }
            sum += b - 64;
        }

        return sum;
    }
}
