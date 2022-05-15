package com.mosk;

import java.util.Arrays;
import java.util.Scanner;

public class SortingApp extends Exception{
    public static void main( String[] args ) throws Exception {

        System.out.println("enter up to 10 ints splitting them with spacebar");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String[] items = input.split(" ");

        int[] arguments = new int[items.length];

        for (int i = 0; i < items.length; i++) arguments[i] = Integer.parseInt(items[i]);

        sort(arguments);

        System.out.println(Arrays.toString(arguments));

    }//main method ends here.

    /**
     * @param array if <= 1 or > 10 throws exception.
     * @return sorted array
     */
    public static String sort(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException("0 arguments passed");
        if (array.length == 1) throw new IllegalArgumentException("only 1 argument passed");
        if (array.length > 10) throw new IllegalArgumentException("more than 10 arguments passed");
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int temp = 0;
                if (array[j] < array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return Arrays.toString(array);
    }
}
