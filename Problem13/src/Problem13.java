/*
    Problem 13
    Found on https://projecteuler.net/problem=13
    Solution by Daniel Ginovker
    5ms solution
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem13 {

    public static final int REQUIRED = 11; //There's no point in adding anything more than the 11th digit

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        double[] numberList = new double[100];
        getDigits(numberList);

        double sum = 0;
        for (double i : numberList)
        {
            sum += i;
        }

        long stop = System.currentTimeMillis();
        System.out.println("The sum is " + sum);
        System.out.println("Time: " + (stop-start) + "ms");
    }

    private static void getDigits(double[] numberList) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("Problem13/src/50digitNums.txt"));

        for (int i = 0; i < 100; i++)
        {
            numberList[i] = Double.parseDouble(in.readLine().substring(0, REQUIRED));
        }
    }
}
