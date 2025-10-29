#include <iostream>
using namespace std;

const int MAX_N = 2 * 1e5;

int t, n, k, x;
int a[MAX_N];

int main() {
    cin >> t;
    while (t--) {
        cin >> n >> k >> x;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
    }
    return 0;
}