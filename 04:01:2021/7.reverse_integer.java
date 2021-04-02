# 1. Pop and Push Digits & Check before Overflow
# Intuition:
# We can build up the reverse integer one digit at a time. While doing so, we can check beforehand whether or not appending another digit would cause overflow.
//pop operation:
# pop = x % 10;
# x /= 10;

//push operation:
# temp = rev * 10 + pop;
# rev = temp;

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

// Complexity Analysis
// Time Complexity: O(log(x)). There are roughly \log_{10}(x) digits in x.
// Space Complexity: O(1).
