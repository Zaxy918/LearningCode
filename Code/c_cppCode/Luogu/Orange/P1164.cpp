#include <iostream>
using namespace std;

const int MAX_N = 101;
const int MAX_M = 10001;

int N, M;
int a[MAX_N];
int dp[MAX_N][MAX_M];

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    for (int i = 0; i <= N; i++) dp[i][0] = 1;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            dp[i][j] = dp[i - 1][j];
            if (j >= a[i - 1]) dp[i][j] += dp[i - 1][j - a[i - 1]];
        }
    }
    cout << dp[N][M];
    return 0;
}