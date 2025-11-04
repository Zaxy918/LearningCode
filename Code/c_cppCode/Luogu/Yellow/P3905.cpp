#include <climits>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 101;

struct Node {
    int u, w;
    bool operator<(const Node &other) const {
        return this->w > other.w;
    }
};
int n, m, d;
int a, b;
int graph[MAX_N][MAX_N];
int dis[MAX_N];
bool vis[MAX_N];
bool damage[MAX_N][MAX_N];
priority_queue<Node> heap;

void init() {
    for (int i = 1; i <= n; i++) {
        dis[i] = INT_MAX;
    }
    dis[a] = 0;
    heap.push({a, 0});
}

void dijkstra() {
    init();
    while (!heap.empty()) {
        Node cur = heap.top();
        heap.pop();
        if (cur.u == b) return;
        if (!vis[cur.u]) {
            vis[cur.u] = true;
            for (int i = 1; i <= n; i++) {
                if (graph[cur.u][i] && cur.w + (damage[cur.u][i] ? graph[cur.u][i] : 0) < dis[i]) {
                    dis[i] = (damage[cur.u][i] ? graph[cur.u][i] : 0) + cur.w;
                    heap.push({i, dis[i]});
                }
            }
        }
    }
}

int main() {
    cin >> n >> m;
    for (int l = 0, i, j, k; l < m; l++) {
        cin >> i >> j >> k;
        graph[i][j] = k;
        graph[j][i] = k; // Notice if the graph is undirected
    }
    cin >> d;
    for (int l = 0, i, j; l < d; l++) {
        cin >> i >> j;
        damage[i][j] = true;
        damage[j][i] = true;
    }
    cin >> a >> b;
    dijkstra();
    cout << dis[b];
    return 0;
}