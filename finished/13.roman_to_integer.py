# 2. Left-to-Right Pass Improved
# total = 0
# i = 0
# while i < s.length:
#     if at least 2 characters remaining and s.substing(i, i + 1) is in values:
#         total = total + (value of s.substring(i, i + 1))
#         i = i + 2
#     else:
#         total = total + (value of s[i])
#         i = i + 1
# return total

values = {
    "I": 1,
    "V": 5,
    "X": 10,
    "L": 50,
    "C": 100,
    "D": 500,
    "M": 1000,
    "IV": 4,
    "IX": 9,
    "XL": 40,
    "XC": 90,
    "CD": 400,
    "CM": 900
}

class Solution:
    def romanToInt(self, s: str) -> int:
        total = 0
        i = 0
        while i < len(s):
            # This is the subtractive case.
            if i < len(s) - 1 and s[i:i+2] in values:
                total += values[s[i:i+2]]
                i += 2
            else:
                total += values[s[i]]
                i += 1
        return total
