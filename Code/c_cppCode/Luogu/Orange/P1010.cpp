#include <iostream>
using namespace std;

const int MAX_P = 14; // n is not bigger than 2 * 1e4

int n;

void dfs(int x) {
    int mask = 1 << MAX_P;
    int p = MAX_P;
    int last = x & -x;
    while (mask) {
        if (mask & x) {
            if (p == 0) {
                cout << "2(0)";
            } else if (p == 1) {
                cout << 2;
            } else {
                cout << "2(";
                dfs(p);
                cout << ")";
            }
            if (mask != last) cout << "+";
        }
        mask >>= 1;
        p--;
    }
}

int main() {
    cin >> n;
    dfs(n);
    return 0;
}