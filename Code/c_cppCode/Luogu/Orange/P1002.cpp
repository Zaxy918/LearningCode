#include <iostream>
using namespace std;

const int MAX_N = 21;
const int DOMAIN[2][9] = {
    {0, 2, 1, -1, -2, -2, -1, 1, 2},
    {0, 1, 2, 2, 1, -1, -2, -2, -1},
};

int B[2], hourse[2];
bool domain[MAX_N][MAX_N];
long long dp[MAX_N][MAX_N];
int res;

void setDomain(int x, int y) {
    for (int i = 0; i < 9; i++) {
        int nx = x + DOMAIN[0][i];
        int ny = y + DOMAIN[1][i];
        if (nx >= 0 && nx <= B[0] && ny >= 0 && ny <= B[1]) domain[nx][ny] = true;
    }
}

int main() {
    cin >> B[0] >> B[1] >> hourse[0] >> hourse[1];
    setDomain(hourse[0], hourse[1]);
    for (int i = 0; i <= B[1]; i++)
        if (domain[0][i])
            break;
        else
            dp[0][i] = 1;
    for (int i = 0; i <= B[0]; i++)
        if (domain[i][0])
            break;
        else
            dp[i][0] = 1;
    for (int i = 1; i <= B[0]; i++) {
        for (int j = 1; j <= B[1]; j++) {
            if (!domain[i][j]) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    cout << dp[B[0]][B[1]];
    return 0;
}