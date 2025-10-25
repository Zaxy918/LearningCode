#include <iostream>
using namespace std;

int n;

int main() {
    cin >> n;
    long long cur = 1, pst = 1;
    for (int i = 2; i <= n; i++) {
        pst = cur;
        cur = pst * (4 * i - 2) / (i + 1);
    }
    cout << cur;
}