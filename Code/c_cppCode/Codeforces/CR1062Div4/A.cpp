#include <iostream>
using namespace std;

int t;
int a, b, c, d;

int main() {
    ios::sync_with_stdio(false);
    cin >> t;
    while (t--) {
        cin >> a >> b >> c >> d;
        if (a > 0 && a == b && a == c && a == d) {
            cout << "YES" << endl;
        } else
            cout << "NO" << endl;
    }
    return 0;
}