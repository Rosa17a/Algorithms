package Sorting;

/**
 * Insertion sort Move down through the array Each item bubbles up above the
 * larger ones above it. Everything above the current item is in order.
 * Everything below the current item is untouched.
 * 
 * Sort random strings: Array of length N - Order of growth is N^2 (will not
 * scale)
 * 
 * 
 */
public class Insertion {
    public static void sort(String[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1].compareTo(a[j]) > 0) {
                    exchange(a, j - 1, j);
                } else
                    break;
            }
        }
    }

    private static void exchange(String[] a, int i, int j) {

        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
