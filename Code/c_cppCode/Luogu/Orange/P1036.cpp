#include <cmath>
#include <iostream>
using namespace std;

const int MAX_X = 1e8 + 1;
const int MAX_N = 21;

bool vst[MAX_X];
int cntP;
int n, k, slts;
int x[MAX_N];

void selPrime() {
    vst[0] = vst[1] = true;
    for (int i = 2; i <= sqrt(MAX_X); i++) {
        if (!vst[i]) {
            for (int j = i * i; j < MAX_X; j += i) {
                vst[j] = true;
            }
        }
    }
}

void dfs(int d, int sum, int idx) {
    if (d == k) {
        if (!vst[sum]) slts++;
        return;
    }
    for (int i = idx; i < n; i++) {
        dfs(d + 1, sum + x[i], i + 1);
    }
}

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> x[i];
    }
    selPrime();
    dfs(0, 0, 0);
    cout << slts;
    return 0;
}