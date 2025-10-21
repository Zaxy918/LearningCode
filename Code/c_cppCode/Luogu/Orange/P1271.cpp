#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_A = 2000001;

int n, m;
int a[MAX_A];

int main() {
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> a[i];
    }
    sort(a, a + m);
    for_each(a, a + m, [](int n) { cout << n << " "; });
    return 0;
}