#include <iostream>
using namespace std;

const int MAX_N = 10;

int n;
int arr[1 << MAX_N][1 << MAX_N];

void dfs(int ns, int sx, int sy, int ex, int ey) {
    if (ns == 0) {
        arr[ex][ey] = 1;
        return;
    }
    int mx = (sx + ex) / 2;
    int my = (sy + ey) / 2;
    dfs(ns - 1, mx, sy, ex, my);
    dfs(ns - 1, sx, my, mx, ey);
    dfs(ns - 1, mx, my, ex, ey);
}

int main() {
    cin >> n;
    dfs(n, 0, 0, (1 << n) - 1, (1 << n) - 1);
    for (int i = 0; i < 1 << n; i++) {
        for (int j = 0; j < 1 << n; j++) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}