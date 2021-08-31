package Sorting;

/**
 * 
 * Abstract inplace merge Merge a[lo, mid) with a[mid, hi). Use auxiliary array
 * for result. Copy back when merge is complete.
 * 
 * Merge Sort Divide array into two halves. Recursively sort each half. Merge
 * two halves to make sorted whole.
 * 
 * Mergesort analysis
 * 
 * Cost model. Count data moves. # of times a string moves from one array to
 * another
 * 
 * Exact analysis for N = 2^n Note that n= lgN. 1 subarrays of size 2^n. 2
 * subarrays of size 2^(n-1). 4 subarrays of size 2^(n-2)
 * ........................... 2^n subarrays of size 1. Total # data moves 2N
 * lgN.
 * 
 */
public class MergeSort {

    public static void sort(String[] a) {

        sort(a, 0, a.length - 1);

    }

    private static void merge(String arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        String L[] = new String[n1];
        String R[] = new String[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) >0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static void sort(String arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
