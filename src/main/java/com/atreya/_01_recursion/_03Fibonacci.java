package com.atreya._01_recursion;

public class _03Fibonacci {

    public static void main(String[] args) {
        // problem 1: print fibonacci series from 0 to target
        System.out.println("print fibonacci series from 0 to target");
        System.out.print(n1 + "\t");
        System.out.print(n2 + "\t");
        printTillTarget(50);

        // problem 2: print sum of fibonacci numbers until target number
        // in other words, what is nth number in fibonacci series ?
        System.out.println("\n\nprint sum of fibonacci numbers until target number");
        System.out.println(fibonacci(10));

        // problem 3: print first n numbers in fibonacci series
        // logic : inside a loop from 0 to n, give me fibonacci sum of first n numbers
        System.out.println("\nprint first n numbers in fibonacci series");
        int n = 12;
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + "\t");
        }
    }

    // series will be printed until target number
    public static int n1 = 0;
    public static int n2 = 1;
    public static int n3;
    public static void printTillTarget(int tillNumber){
        n3 = n1 + n2;
        if (n3 > tillNumber) return;
        System.out.print(n3 + "\t");
        n1 = n2;
        n2 = n3;
        printTillTarget(tillNumber);
    }

    // series will be printed until target number
    public static int fibonacci(int number){
        if (number == 0) return 0;
        if(number == 1 || number == 2) return 1;
        return fibonacci(number-1) + fibonacci(number -2);
    }
}
