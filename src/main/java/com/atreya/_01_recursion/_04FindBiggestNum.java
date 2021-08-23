package com.atreya._01_recursion;

public class _04FindBiggestNum {
    static int highest = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // find biggest number in unsorted array using recurrsion
        int[] array = {3,7,32,1,7,9,0, 74};
        int biggestNumber = findBigggestNumber(array, array.length-1);
        System.out.println(biggestNumber);
    }
    // find biggest number in unsorted array using recurrsion
    public static int findBigggestNumber(int[] array, int n){
        if(n == -1) return highest;
        if(array[n] > highest) highest = array[n];
        return findBigggestNumber(array, n-1);
    }
}

/*
Time complexity:

findBigggestNumber(array, n-1);             T(n)
... rest of statements :                    O(1)
return findBigggestNumber(array, n-1)       T(n-1)

s1: T(n) = O(1) + T(n-1)
s2: find base condition: in what value of 'n', recurrence will not be executed :
    In our case, base condition is n == -1
    So, T(-1) will be order of 1
s3: T(-1) = O(1) : base condition
s4: T(n-1) = O(1) + T((n-1)-1) : by substituting
s5: T(n-2) = O(1) + T((n-2)-1) :

s6: T(n) = 1 + T(n-1)
         = 1 + O(1) + T((n-1)-1)
         = 2 + T(n-2)
         = 2 + O(1) + T((n-2)-1)
         = 2 + 1 + T(n-3)
         = 3 + T(n-3)
         .
         .
         = k + T(n-k)

s7: Now Eliminate T fn. to elimiate we need to make it T(-1) because we know the value of T(-1)
    To do so, substitute k as (n+1), so equation becomes:

    (n+1) + T(n - (n + 1))
    n + T(-1)
    n + O(1)
    n
*/























