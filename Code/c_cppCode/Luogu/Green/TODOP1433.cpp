#include <climits>
#include <cmath>
#include <iostream>
using namespace std;

const int MAX_N = 15;

int n;
long double res = INT_MAX;
pair<long double, long double> pos[MAX_N];
long double dp[MAX_N][MAX_N][MAX_N][MAX_N];
bool vis[MAX_N];

double calDis(long double x1, long double x2, long double y1, long double y2) {
    return powl((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2), 0.5);
}

void dfs(int d, long double preX, long double preY, long double x, long double y, long double dis) {
    if (d == n) {
        res = min(dis, res);
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            vis[i] = true;
            dfs(d + 1, x, y, pos[i].first, pos[i].second, dis + calDis(pos[i].first, x, pos[i].second, y));
            vis[i] = false;
        }
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> pos[i].first >> pos[i].second;
    }
    for (int i = 0; i < n; i++) {
        vis[i] = true;
        dfs(1, 0, 0, pos[i].first, pos[i].second, calDis(0, pos[i].first, 0, pos[i].second));
        vis[i] = false;
    }
    printf("%.2Lf", res);
    return 0;
}