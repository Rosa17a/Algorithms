package Sorting;

/**
 * Deteching repeats in a string
 * 
 * Longets repeated substring * Given: A string s. * Task: Find the longest
 * substring in s that appears at least twice.
 * 
 * LRS applications
 * 
 * 
 */
public class LongestRepeatedSubstring {

    /**
     * 
     * @implSpec ~ N^2/2 calls on lcp(). Dose not scale.
     * 
     * 
     * @param s
     * @return String
     */

    public static String lrsBrureForce(String s) {
        int N = s.length();
        String lrs = "";
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String x = lcp(s.substring(i, N), s.substring(j, N));
                if (x.length() > lrs.length()) {
                    lrs = x;
                }
            }
        }
        return lrs;
    }

    /**
     * 
     * @implSpec N calls on substring(). N calls on lcp. Potentially scales.
     * 
     * 
     * 
     * @param s
     * @return String
     */

    public static String lrs(String s) {

        int N = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {

            suffixes[i] = s.substring(i, N);

        }

        MergeSort.sort(suffixes);

        String lrs = "";
        for (int i = 0; i < N - 1; i++) {

            String x = lcp(suffixes[i], suffixes[i + 1]);

            if (x.length() > lrs.length()) {
                lrs = x;

            }
        }
        return lrs;
    }

    /**
     * Longest common prefix Given: Two strings string s and t. Task: Find the
     * longest substring that appears at the beginning of both strings.
     */
    private static String lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++)
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        return s.substring(0, N);
    }
}
