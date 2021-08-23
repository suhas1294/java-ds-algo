package com.atreya._12_sorting._01_bubble;

public class BubbleSortMain {

    public static void main(String[] args) {

        BubbleSort ob = new BubbleSort();
        int arr[] = { 10, 5, 30, 15, 50, 6 };
        System.out.println("Array to be sorted...");
        ob.printArray(arr);

        ob.bubbleSort(arr);

        System.out.println("Sorted Array...");
        ob.printArray(arr);

    }// end of method

}
