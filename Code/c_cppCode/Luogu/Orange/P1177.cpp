#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 1e5;

int N;
int a[MAX_N];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    sort(a, a + N);
    for_each(a, a + N, [](int n) { cout << n << " "; });
    return 0;
}