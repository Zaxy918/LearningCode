#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 5 * 1e6;

int n, k;
int a[MAX_N];

int main() {
    ios::sync_with_stdio(false);
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n);
    cout << a[k];
    return 0;
}