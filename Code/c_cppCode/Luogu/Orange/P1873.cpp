#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 1e6 + 1;

int n, m;
long long trees[MAX_N];
long long maxH;

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> trees[i];
        maxH = max(maxH, trees[i]);
    }
    long long l = 0, r = maxH + 1;
    while (l < r) {
        long long mid = (l + r) / 2;
        long long cut = 0;
        for_each(trees, trees + n, [&cut, mid](long long t) { cut += t - mid > 0 ? t - mid : 0; });
        if (cut >= m) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    cout << r - 1;
    return 0;
}