package SearchingAlgorithms;

/**
 * Keep the array in sorted order. Examine the middle key. if it matches, return
 * its index. if it is larger, search the half with lower indices. if it is
 * smaller, search the half with upper indices.
 * 
 * Binary search arithmetic
 * 
 * Notation: a[lo,hi) means a[lo], a[lo+1]....a[hi-1] does not include a[hi]
 * 
 * Search a[lo, hi] mid = lo + (hi-lo)/2
 * 
 * Lower half: a[lo, mid] Upper half: a[mid+1, hi]
 * 
 * Mathematical analysis of binary search
 * 
 * Exact analysis for search miss for N = 2^n -1 Note that n = lg(N+1) ~ lgN
 * Subarray size for 1st call is 2^n -1 Subarray size for 2nd call is 2^(n-1) -1
 * ........................................ Subarray size for nth call is 1
 * Total number compares (one per call): n~lgN
 * 
 * Binary search uses ~ lgN compares for a search miss.
 * 
 * Binary search uses ~ lgN compares for random search hit.
 * 
 * Order of growth is NlogN (will scale)
 */
public class BinarySearch {

    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }

    private static int search(String key, String[] a, int lo, int hi) {
        if (hi <= lo)
            return -1;
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].compareTo(key);
        if (cmp > 0)
            return search(key, a, lo, mid);
        else if (cmp < 0)
            return search(key, a, mid + 1, hi);
        else
            return mid;
    }
}
