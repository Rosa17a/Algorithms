package SearchingAlgorithms;

/**
 * Strawman implementation: Sequental search Check each array entry 0,1,2,3 ....
 * n for match with search string. if match found, return index of the matching
 * string, if not, return -1. Mathematical analysis of whitelist filter using
 * Sequential search Model N strings on the whitelist, cN transactions for
 * constant c, String length not long
 * 
 * Analysis A random search hit checks about half of the N strings on the
 * whitelist, on average, A random search miss checks all of the N strings on
 * the whitelist. on average. Expected order of growth of running time: N^2
 */
public class SequentialSearch {

    public static int search(String key, String[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i].compareTo(key) == 0)
                return i;
        return -1;
    }
}
