package com.atreya._01_recursion;

public class _05BinarySearch {
    public static void main(String[] args) {
        int[] input = {10, 20, 30,40, 50, 60, 70, 80, 90, 100, 110};
        int targetNum = 1120;
        int result = binarySearch(targetNum, input, 0, input.length-1);
        System.out.println(String.format("target number(%d) found in %dth index", targetNum, result));
    }

    public static int binarySearch(int findNumber, int[] arr, int start, int end){
        if (start == end && arr[start] == findNumber) return start; // base condition
        if (start == end && arr[start] != findNumber) throw new RuntimeException("Not found!"); // base condition
        int mid = (start + end)/2;
        if (arr[mid] > findNumber){
            return binarySearch(findNumber, arr, start, mid-1);
        }else if(arr[mid] < findNumber){
            return binarySearch(findNumber, arr, mid+1, end);
        }else if(arr[mid] == findNumber){
            return mid;
        }
        return -1;
    }
}

/*
s1: binarySearch : T(n)
s2: ...rest of code is O(1)
s3: binarySearch(findNumber, arr, start, mid): O(n/2)
s4: binarySearch(findNumber, arr, mid+1, end): O(n/2)
s5: base condition: T(1) = 1
    T(n) = O(1) + T(n/2)
    T(n/2) = O(1) + T(n/4)
    T(n/4) = O(1) + T(n/8)

    After substituting..
    T(n) = T(n/8) + 3
    T(n) = T(n/2^k) + k

    Eliminate T fn.
    how ? : put some value of k for which entire T(n/2^k) becomes T(1) so that we already know T(1)

    n/2^k = 1
    n = 2^k
    log(n) = k

    So, now we have
    T(n) = T(n/2^k) + k
    T(n) = T(1) + log(n)
    T(n) = 1 + log(n)
    T(n) = log(n)

*/