#include <iostream>
using namespace std;

const int MAX_N = 21;

long long C[MAX_N];

long long catalan1(int n) {
    /*
     * C[0] = 1;
     * C[n] = Σ(i = 0,n - 1)C[i] * C[n - 1 - i];
     */
    C[0] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
            C[i] += C[j] * C[i - 1 - j];
        }
    }
    return C[n];
}

long long catalan2(int n) {
    /*
     * C[0] = 1;
     * C[n] = C[n-1] * (4 * n - 2) / (n + 1)
     */
    C[0] = 1;
    for (int i = 1; i <= n; i++) {
        C[i] = C[i - 1] * (4 * i - 2) / (i + 1);
    }
    return C[n];
}

int main() {
    cout << catalan1(5) << endl;
    cout << catalan2(5) << endl;
    return 0;
}