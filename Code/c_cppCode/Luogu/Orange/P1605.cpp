#include <iostream>
using namespace std;

const int MAX_N = 6;
const int MOVE[5] = {-1, 0, 1, 0, -1};

int n, m, t;
int sx, sy, fx, fy;
bool track[MAX_N][MAX_N];
bool vis[MAX_N][MAX_N];
long long res;

void dfs(int x, int y) {
    if (x == fx && y == fy) {
        res++;
        return;
    }
    for (int i = 0, dx, dy; i < 4; i++) {
        dx = x + MOVE[i];
        dy = y + MOVE[i + 1];
        if (dx > 0 && dy > 0 && dx <= n && dy <= m && !track[dx][dy] && !vis[dx][dy]) {
            vis[dx][dy] = true;
            dfs(dx, dy);
            vis[dx][dy] = false;
        }
    }
}

int main() {
    cin >> n >> m >> t;
    cin >> sx >> sy >> fx >> fy;
    for (int i = 0, tx, ty; i < t; i++) {
        cin >> tx >> ty;
        track[tx][ty] = true;
    }
    vis[sx][sy] = true; //* Don't forget this.
    dfs(sx, sy);
    cout << res;
    return 0;
}