/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VariableTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Shahan
 */
public class CompratorExample {

    void sortArray() {
        int arr[] = {1,4,2,3,10,11,12,51,9};
        Arrays.sort(arr);
        System.out.println("Sorted int array is " + Arrays.toString(arr));

        String[] strArr = {"A", "C", "B", "Z", "E"};
        Arrays.sort(strArr);
        System.out.println("Sorted string array is " + Arrays.toString(strArr));
        
        ArrayList<String> obj=new ArrayList<String>();
        obj.add("Z");
        obj.add("E");
        obj.add("B");
        obj.add("A");
        Collections.sort(obj);
        System.out.println(obj.toString());
    }

    public static void main(String abc[]) {
    CompratorExample obj=new CompratorExample();
    obj.sortArray();
    }//end of main

}//end of class

