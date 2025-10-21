#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 21;

int n;
string a[MAX_N];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n, [](string a, string b) { return a + b > b + a; });
    for_each(a, a + n, [](string s) { cout << s; });
    return 0;
}