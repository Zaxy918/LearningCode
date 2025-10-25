#include <iostream>
using namespace std;

const int MAX_N = 1e6 + 1;
const int MOD = 1e4;

int N;
long long dp[MAX_N];
long long sum[MAX_N];

int main() {
    cin >> N;
    // dp[i] = dp[i - 1] + dp[i - 2] + 2*(dp[i - 3] + ... + dp[0]);
    dp[0] = dp[1] = 1, dp[2] = 2, dp[3] = 5;
    sum[0] = 1, sum[1] = 2, sum[2] = 4, sum[3] = 9;
    for (int i = 4; i <= N; i++) {
        // dp[i] = (dp[i - 1] * 2 % MOD + dp[i - 3] % MOD) % MOD;
        dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + (2 * sum[i - 3]) % MOD) % MOD;
        sum[i] = (sum[i - 1] + dp[i]) % MOD;
    }
    cout << dp[N];
    return 0;
}