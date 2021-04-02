# 1. Substring: Linear Time Slice

class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();

    for (int start = 0; start < n - L + 1; ++start) {
      if (haystack.substring(start, start + L).equals(needle)) {
        return start;
      }
    }
    return -1;
  }
}

# Complexity Analysis:
# Time Complexity: O((N-L)L) where N is a length of haystack and L is a length of needle. We compute a substring of length L in a loop, which is executed (N - L) times.
# Space Complexity: O(1)

# 2. Two Pointers: Linear Time Slice
class Solution {
public int strStr(String haystack, String needle) {
  int L = needle.length(), n = haystack.length();
  if (L == 0) return 0;

  int pn = 0;
  while (pn < n - L + 1) {
    // find the position of the first needle character
    // in the haystack string
    while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

    // compute the max match string
    int currLen = 0, pL = 0;
    while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
      ++pn;
      ++pL;
      ++currLen;
    }

    // if the whole needle string is found,
    // return its start position
    if (currLen == L) return pn - L;

    // otherwise, backtrack
    pn = pn - currLen + 1;
  }
  return -1;
    
# Complexity Analysis:
# Time Complexity: O((N-L)L)
# Space Complexity: O(1)

# 3. Rabin Karp: Constant Time Slice
class Solution {
  // function to convert character to integer
  public int charToInt(int idx, String s) {
    return (int)s.charAt(idx) - (int)'a';
  }

  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L > n) return -1;

    // base value for the rolling hash function
    int a = 26;
    // modulus value for the rolling hash function to avoid overflow
    long modulus = (long)Math.pow(2, 31);

    // compute the hash of strings haystack[:L], needle[:L]
    long h = 0, ref_h = 0;
    for (int i = 0; i < L; ++i) {
      h = (h * a + charToInt(i, haystack)) % modulus;
      ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
    }
    if (h == ref_h) return 0;

    // const value to be used often : a**L % modulus
    long aL = 1;
    for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

    for (int start = 1; start < n - L + 1; ++start) {
      // compute rolling hash in O(1) time
      h = (h * a - charToInt(start - 1, haystack) * aL
              + charToInt(start + L - 1, haystack)) % modulus;
      if (h == ref_h) return start;
    }
    return -1;
  }
}
