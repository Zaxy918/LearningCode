#include <iostream>
using namespace std;

const int MAX_N = 1001;

int n;
long long dp[MAX_N];

int main() {
    cin >> n;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = 1;
        for (int j = 1; j <= i / 2; j++) {
            dp[i] += dp[j];
        }
    }
    cout << dp[n];
    return 0;
}