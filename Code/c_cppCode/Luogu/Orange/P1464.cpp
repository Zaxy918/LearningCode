#include <iostream>
using namespace std;

const int MAX_N = 21;

long long a, b, c;
long long dp[MAX_N][MAX_N][MAX_N];

int main() {
    for (int i = 0; i < MAX_N; i++) {
        for (int j = 0; j < MAX_N; j++) {
            for (int k = 0; k < MAX_N; k++) {
                if (i == 0 || j == 0 || k == 0)
                    dp[i][j][k] = 1;
                else if (i < j && j < k)
                    dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                else
                    dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
            }
        }
    }
    while (cin >> a >> b >> c && !(a == -1 && b == -1 && c == -1)) {
        if (a <= 0 || b <= 0 || c <= 0)
            printf("w(%lld, %lld, %lld) = 1\n", a, b, c);
        else if (a > 20 || b > 20 || c > 20)
            printf("w(%lld, %lld, %lld) = %lld\n", a, b, c, dp[20][20][20]);
        else
            printf("w(%lld, %lld, %lld) = %lld\n", a, b, c, dp[a][b][c]);
    }
    return 0;
}