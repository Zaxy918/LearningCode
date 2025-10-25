#include <climits>
#include <cmath>
#include <iostream>
using namespace std;

const int MAX_N = 11;

int n;
int dos[MAX_N][2];
int res;

int dfs(int d, int sour, int bitt, int cnt) {
    if (d == n) {
        if (cnt != 0) {
            return abs(sour - bitt);
        }
        return INT_MAX;
    }
    return min(dfs(d + 1, sour * dos[d][0], bitt + dos[d][1], cnt + 1), dfs(d + 1, sour, bitt, cnt));
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> dos[i][0] >> dos[i][1];
    }
    res = dfs(0, 1, 0, 0);
    cout << res;
    return 0;
}