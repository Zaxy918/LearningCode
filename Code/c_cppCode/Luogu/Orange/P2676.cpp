#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 20000;

int N, B;
int H[MAX_N];
int S, cnt;

int main() {
    ios::sync_with_stdio(false);
    cin >> N >> B;
    for (int i = 0; i < N; i++) {
        cin >> H[i];
    }
    sort(H, H + N, greater<int>());
    for (cnt = 0; cnt < N; cnt++) {
        S += H[cnt];
        if (S >= B)
            break;
    }
    cout << cnt + 1;
    return 0;
}