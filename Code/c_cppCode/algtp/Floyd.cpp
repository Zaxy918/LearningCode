// P2910
#include <climits>
#include <iostream>
using namespace std;

const int MAX_N = 101;
const int MAX_M = 10001;

int n, m;
int res;
int a[MAX_M];
int dis[MAX_N][MAX_N];
int cnt;

void init() {
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            dis[i][j] = INT_MAX;
        }
    }
}

// Find a min dis path from i to j through k.
void Floyd() {
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dis[i][k] != INT_MAX && dis[k][j] != INT_MAX) {
                    dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
    }
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> a[i];
    }
    init();
    for (int i = 1; i <= n; i++) {
        for (int j = 1, d; j <= n; j++) {
            cin >> dis[i][j];
        }
    }
    Floyd();
    for (int i = 0; i < m - 1; i++) {
        res += dis[a[i]][a[i + 1]];
    }
    cout << res;
}