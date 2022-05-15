package com.mosk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CornerCasesTesting {
    protected SortingApp sortingApp = new SortingApp();

    private int[] arrayTest;
    private String expected;

    public CornerCasesTesting (int[] arrayTest, String expected){
        this.arrayTest = arrayTest;
        this.expected = expected;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroArgsCase(){
        int[] zeroArgsArray = new int[0];
        SortingApp.sort(zeroArgsArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOneArgCase(){
        int[] oneArgArray = new int[1];
        SortingApp.sort(oneArgArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoreThanTenArgsCase(){
        int[] zeroArray = new int[11];
        SortingApp.sort(zeroArray);
    }

    @Test
    public void testTwoToTenAgrsCase(){
        assertEquals(expected, SortingApp.sort(arrayTest));
    }

    @Parameterized.Parameters
    public static Collection input(){
        int[] array1 = {1, -2},
                array2 = {100, 41, -5, 0},
                array3 = {555, 45, -1, 1, 0, 10},
                array4 = {9, 5, 4, 1, 2, 3, 7, 6, 10, 8};
        return Arrays.asList(new Object[][]{
                {array1, "[-2, 1]"},
                {array2, "[-5, 0, 41, 100]"},
                {array3, "[-1, 0, 1, 10, 45, 555]"},
                {array4, "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"}});
    }
}
