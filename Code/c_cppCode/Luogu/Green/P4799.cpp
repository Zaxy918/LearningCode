#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 40;

int n;
long long m;
long long ans;

long long price[MAX_N];
long long lres[1 << (MAX_N / 2)];
long long rres[1 << (MAX_N / 2)];
long long cntl, cntr;

void dfs(int s, int e, long long sum, long long *res, long long &cnt) {
    if (sum > m) return;
    if (s == e) {
        res[cnt++] = sum;
        return;
    }
    dfs(s + 1, e, sum, res, cnt);
    dfs(s + 1, e, sum + price[s], res, cnt);
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> price[i];
    }
    dfs(0, n >> 1, 0, lres, cntl);
    dfs(n >> 1, n, 0, rres, cntr);
    sort(lres, lres + cntl);
    sort(rres, rres + cntr);
    int l = 0, r = cntr - 1;
    while (l < cntl) {
        if (lres[l] + rres[r > 0 ? r : 0] <= m) {
            ans += r + 1;
            l++;
        } else {
            r -= r > 0 ? 1 : 0;
        }
    }
    cout << ans;
    return 0;
}