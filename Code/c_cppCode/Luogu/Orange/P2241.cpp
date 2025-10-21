#include <iostream>
using namespace std;

const int MAX_V = 5001;

long long n, m;
long long squares, blocks;

int main() {
    cin >> n >> m;
    for (long long i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            squares += min(n - i, m - j);
        }
    }
    blocks = (n + 1) * (m + 1) * m * n / 4;
    cout << squares << " " << blocks - squares;
    return 0;
}