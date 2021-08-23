package com.atreya._01_recursion;

public class _01PrintNumbers {
    public static int printNumbersRecursively(int fromNumber){
        if (fromNumber < 1) return 0;
        System.out.print(fromNumber + "\t");
        return printNumbersRecursively(fromNumber-1);
    }
    public static void main(String[] args) {
        System.out.println(printNumbersRecursively(10));
    }
}
