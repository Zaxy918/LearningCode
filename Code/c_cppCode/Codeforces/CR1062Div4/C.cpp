#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 2 * 1e5 + 1;

int t, n;
int toys[MAX_N];
bool allEven, allOdd;

int main() {
    ios::sync_with_stdio(false);
    cin >> t;
    while (t--) {
        cin >> n;
        allEven = true;
        allOdd = true;
        for (int i = 0; i < n; i++) {
            cin >> toys[i];
            if (toys[i] % 2) allEven = false;
            if (toys[i] % 2 == 0) allOdd = false;
        }
        if (allEven || allOdd) {
            for_each(toys, toys + n, [](int a) { cout << a << " "; });
        } else {
            sort(toys, toys + n, [](int a, int b) { return a < b; });
            for_each(toys, toys + n, [](int a) { cout << a << " "; });
        }
        cout << endl;
    }
    return 0;
}