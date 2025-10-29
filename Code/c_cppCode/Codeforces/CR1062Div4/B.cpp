#include <algorithm>
#include <iostream>
using namespace std;

int q;
int n;
string a, b;

int main() {
    cin >> q;
    while (q--) {
        cin >> n;
        cin >> a >> b;
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        if (a == b) {
            cout << "YES" << endl;
        } else
            cout << "NO" << endl;
    }
    return 0;
}