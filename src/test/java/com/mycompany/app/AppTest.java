package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testSearchFound(){
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1,2,3,4));
        assertTrue(new App().search(array,4));
    }

    public void testArrayUnionEqual(){
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(4,5,6));
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(7,8,9));
        ArrayList<Integer> array4 = new ArrayList<>(Arrays.asList(10,11,12));
        ArrayList<Integer> array5 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        ArrayList<Integer> arrayFinal = new App().arrayUnion(array1, array2, array3, array4);
        assertTrue(arrayFinal.equals(array5));
    }

    public void testArrayUnionOneOfThemIsNull(){
        ArrayList<Integer> array1 = null;
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(4,5,6));
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(7,8,9));
        ArrayList<Integer> array4 = new ArrayList<>(Arrays.asList(10,11,12));
        ArrayList<Integer> array5 = new ArrayList<>(Arrays.asList(4,5,6,7,8,9,10,11,12));
        ArrayList<Integer> arrayFinal = new App().arrayUnion(array1, array2, array3, array4);
        assertTrue(arrayFinal.equals(array5));
    }
    public void testArrayUnionAllOfThemIsEmpty(){
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        ArrayList<Integer> array3 = new ArrayList<>();
        ArrayList<Integer> array4 = new ArrayList<>();
        ArrayList<Integer> array5 = new ArrayList<>();
        ArrayList<Integer> arrayFinal = new App().arrayUnion(array1, array2, array3, array4);
        assertTrue(arrayFinal.equals(array5));
    }
    public void testArrayUnionCollides(){
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1,2));
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(2,3));
        ArrayList<Integer> array4 = new ArrayList<>(Arrays.asList(2,4));
        ArrayList<Integer> array5 = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> arrayFinal = new App().arrayUnion(array1, array2, array3, array4);
        assertTrue(arrayFinal.equals(array5));
    }


}
