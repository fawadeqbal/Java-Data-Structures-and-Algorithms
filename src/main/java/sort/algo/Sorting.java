/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort.algo;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author fawad
 */
public class Sorting {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[50];

        for (int i = 0; i < arr.length; i++) {
        arr[i] = rand.nextInt(101); // generates a random integer in the range of 0 to 100 (inclusive)
}

//        //Bubble Sort
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
        int[] arr1 = {7, 8, 3, 1, 4};
        int n = arr.length;
//        for (int i = 1; i < n; i++) {
//            int key = arr1[i];
//            int j = i - 1;
//            while (j >= 0 && arr1[j] > key) {
//                arr1[j + 1] = arr1[j];
//                j--;
//            }
//            arr1[j + 1] = key;
//        }
        
        for (int i = 0; i < n-1 ; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
