#include <climits>
#include <iostream>
#include <queue>
using namespace std;

const int MOD = 100003;
const int MAX_N = 1e6 + 1;
const int MAX_M = 2 * 2 * 1e6;

int n, m;
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
int cnt;
int path[MAX_N];
int dis[MAX_N];
queue<int> q;
bool vis[MAX_N];

void addEdge(int u, int v) {
    nexte[++cnt] = head[u];
    head[u] = cnt;
    to[cnt] = v;
}

void bfs() {
    fill(dis + 1, dis + n + 1, INT_MAX);
    path[1] = 1;
    q.push(1);
    dis[1] = 0;
    while (!q.empty()) {
        for (int i = 0, size = q.size(), u; i < size; i++) {
            u = q.front(), q.pop();
            if (!vis[u]) {
                vis[u] = true;
                for (int j = head[u]; j > 0; j = nexte[j]) {
                    if (dis[u] + 1 <= dis[to[j]]) {
                        dis[to[j]] = dis[u] + 1;
                        path[to[j]] = (path[to[j]] + path[u]) % MOD;
                        q.push(to[j]);
                    }
                }
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0, x, y; i < m; i++) {
        cin >> x >> y;
        addEdge(x, y);
        addEdge(y, x);
    }
    bfs();
    for (int i = 1; i <= n; i++) cout << path[i] << endl;
    return 0;
}