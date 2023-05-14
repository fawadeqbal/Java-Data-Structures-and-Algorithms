/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort.algo;

/**
 *
 * @author fawad
 */
public class Sort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for(int j=0;j<n;j++){
            System.out.print(arr[j]+"\t");
        }
        System.out.println("");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int j=0;j<n;j++){
            System.out.print(arr[j]+"\t");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr={22,56,23,54,76,89,75,45};
        insertionSort(arr);
        
    }

}
