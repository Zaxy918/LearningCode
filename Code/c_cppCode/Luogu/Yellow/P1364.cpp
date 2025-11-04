#include <climits>
#include <iostream>
using namespace std;

const int MAX_N = 101;

int n;
int peo[MAX_N];
long long res = LLONG_MAX, dis[MAX_N][MAX_N];

void floyd() {
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dis[i][k] != LLONG_MAX && dis[k][j] != LLONG_MAX) {
                    dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
    }
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            dis[i][j] = LLONG_MAX;
        }
    }
    for (int i = 1, w, u, v; i <= n; i++) {
        cin >> w >> u >> v;
        peo[i] = w;
        dis[i][i] = 0;
        if (u) dis[i][u] = dis[u][i] = 1;
        if (v) dis[i][v] = dis[v][i] = 1;
    }
    floyd();
    for (long long i = 1, sum; i <= n; i++) {
        sum = 0;
        for (int j = 1; j <= n; j++) {
            sum += dis[i][j] * peo[j];
        }
        res = min(sum, res);
    }
    cout << res;
    return 0;
}