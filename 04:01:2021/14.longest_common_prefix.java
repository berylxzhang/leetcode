# 1. Horizontal scanning
 public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    return prefix;
}

# Complexity Analysis
# 1. Time complexity : O(S) , where S is the sum of all characters in all strings.
# In the worst case all n strings are the same. The algorithm compares the string S1 with the other strings [S2…Sn] There are S character comparisons, where S is the sum of all characters in the input array.
# 2. Space complexity : O(1). We only used constant extra space.


# 2. Vertical scanning
# Imagine a very short string is the common prefix at the end of the array. The above approach will still do SS comparisons. One way to optimize this case is to do vertical scanning. We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column.

public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);
        }
    }
    return strs[0];
}

# Complexity Analysis
# 1. Time complexity : O(S) , where S is the sum of all characters in all strings.
# In the worst case there will be nn equal strings with length m and the algorithm performs S=m⋅n character comparisons.
# Even though the worst case is still the same as Approach 1, in the best case there are at most n⋅minLen comparisons where minLenminLen is the length of the shortest string in the array.
# 2. Space complexity : O(1). We only used constant extra space.

# 3. Divide and conquer

public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
}

private String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
        return strs[l];
    }
    else {
        int mid = (l + r)/2;
        String lcpLeft =   longestCommonPrefix(strs, l , mid);
        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
        return commonPrefix(lcpLeft, lcpRight);
   }
}

String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; i++) {
        if ( left.charAt(i) != right.charAt(i) )
            return left.substring(0, i);
    }
    return left.substring(0, min);
}

# Complexity Analysis
# 1. Time complexity : O(S) 
# 2. Space complexity : O(m*logn).
