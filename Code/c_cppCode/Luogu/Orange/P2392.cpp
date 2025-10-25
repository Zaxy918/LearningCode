#include <algorithm>
#include <climits>
#include <cstring>
#include <iostream>
using namespace std;

const int MAX_S = 21;
const int MAX_N = 61;

int s[4];
int ABCD[4][MAX_S];
int brain[2];
int res, tmpRes;

void dfs(int sbjct, int d) {
    if (d == s[sbjct]) {
        tmpRes = min(tmpRes, max(brain[0], brain[1]));
        return;
    }
    brain[0] += ABCD[sbjct][d];
    dfs(sbjct, d + 1);
    brain[0] -= ABCD[sbjct][d];
    brain[1] += ABCD[sbjct][d];
    dfs(sbjct, d + 1);
    brain[1] -= ABCD[sbjct][d];
}

int main() {
    cin >> s[0] >> s[1] >> s[2] >> s[3];
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < s[i]; j++) {
            cin >> ABCD[i][j];
        }
    }
    for (int i = 0; i < 4; i++) {
        tmpRes = INT_MAX;
        brain[0] = brain[1] = 0;
        dfs(i, 0);
        res += tmpRes;
    }
    cout << res;
    return 0;
}