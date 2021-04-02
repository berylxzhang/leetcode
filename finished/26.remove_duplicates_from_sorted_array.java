# 1. two pointers

public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}

# Complexity Analysis
# Time Complexity: O(n). Assume that nn is the length of array. Each of ii and jj traverses at most nn steps.
# Space Complexity: O(1).
