#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 1e5;
const int MAX_A = 5 * 1e3 + 1;
const int MOD = 1e9 + 7;

int n;
int a[MAX_N], cntA[MAX_A];
long long res;

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        cntA[a[i]]++;
    }
    sort(a, a + n, greater<int>());
    for (long long i = 0; i < n - 2; i += cntA[a[i]]) {
        if (cntA[a[i]] >= 2) {
            long long cbnt = (cntA[a[i]] * (cntA[a[i]] - 1)) / 2;
            long long coe = 0;
            for (int j = i + cntA[a[i]]; a[j] * 2 >= a[i]; j += cntA[a[j]]) {
                if (a[j] * 2 == a[i]) {
                    coe += (cntA[a[j]] * (cntA[a[j]] - 1)) / 2;
                } else if (cntA[a[i] - a[j]] > 0)
                    coe += (cntA[a[j]] * cntA[a[i] - a[j]]) % MOD;
            }
            res = (cbnt * coe + res) % MOD;
        }
    }
    cout << res;
    return 0;
}