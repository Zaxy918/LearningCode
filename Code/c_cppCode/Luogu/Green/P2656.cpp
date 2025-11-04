#include <climits>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 8 * 1e4 + 1;
const int MAX_M = 2 * 1e5 + 1;

int n, m, s;
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
int weight[MAX_M];
double ratio[MAX_M];
int cnt;
int dis[MAX_N];
bool vis[MAX_N];
bool enter[MAX_N];
queue<int> q;

void addEdge(int u, int v, int w, double r) {
    nexte[++cnt] = head[u];
    head[u] = cnt;
    to[cnt] = v;
    weight[cnt] = w;
    ratio[cnt] = r;
}

void init() {
    fill(dis + 1, dis + n + 1, INT_MAX);
    dis[s] = 0;
    q.push(s);
    enter[s] = true;
}

void spfa() {
    init();
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        if (!vis[u]) {
            for (int i = head[u]; i > 0; i = nexte[i]) {
                if (dis[u] + weight[i] < dis[to[i]]) {
                    dis[to[i]] = dis[u] + weight[i];
                    if (!enter[to[i]]) {
                        q.push(to[i]);
                        weight[i] *= ratio[i];
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
    double r;
    for (int i = 0, u, v, w; i < m; i++) {
        cin >> u >> v >> w >> r;
        addEdge(u, v, -w, r);
    }
    cin >> s;
    spfa();
    int ans = 0;
    for (int i = 1; i <= m; i++) {
        ans = min(dis[i], ans);
    }
    cout << -ans;
    return 0;
}