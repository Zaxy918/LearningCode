#include <iostream>
#include <vector>
using namespace std;
class Solution {
  public:
    int longestCommonSubsequence(string text1, string text2) {
        if (text2.length() > text1.length()) swap(text1, text2);
        int len1 = text1.length();
        int len2 = text2.length();
        vector<int> dp(len2 + 1, 0);
        int pre = 0, bkup;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                bkup = dp[j];
                if (text1[i - 1] == text2[j - 1])
                    dp[j] = 1 + pre;
                else
                    dp[j] = max(dp[j - 1], dp[j]);
                pre = bkup;
            }
        }
        return dp[len2];
    }
};