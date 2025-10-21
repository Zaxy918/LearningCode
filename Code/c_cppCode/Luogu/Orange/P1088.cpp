#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 10001;

int N, M;
int pmt[MAX_N];

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> pmt[i];
    }
    for (int i = 0; i < M; i++) {
        next_permutation(pmt, pmt + N);
    }
    for_each(pmt, pmt + N, [](int n) { cout << n << " "; });
    return 0;
}