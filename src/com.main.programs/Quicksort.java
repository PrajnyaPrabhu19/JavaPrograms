package com.main.programs;

/*
Program to sort the array using Quicksort algorithm. worst case O(n2)
 */

public class Quicksort{

    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    public static int[]  sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {20 , 10, 80, 50, 40, 60, 70};
        int n = arr.length;

        arr = sort(arr, 0, n-1);
        for(int i=0; i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}