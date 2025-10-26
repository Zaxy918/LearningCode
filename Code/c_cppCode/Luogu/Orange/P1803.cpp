#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 1e6 + 1;

int n, res;
struct Contest {
    int a, b;
} cts[MAX_N];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> cts[i].a >> cts[i].b;
    }
    sort(cts, cts + n, [](Contest a, Contest b) { return a.b < b.b; });
    int end = 0;
    for (int i = 0; i < n; i++) {
        if (cts[i].a >= end) {
            end = cts[i].b;
            res++;
        }
    }
    cout << res;
    return 0;
}