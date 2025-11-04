#include <climits>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 1e5 + 1;
const int MAX_M = 5 * 1e5 + 1;

struct Node {
    int u;
    int w;
    bool operator<(const Node &other) const {
        return this->w > other.w;
    }
};
int n, m, s;
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
int weight[MAX_M];
int dis[MAX_N];
bool vis[MAX_N];
int cnt;
priority_queue<Node> heap;

void init() {
    fill(dis + 1, dis + n + 1, INT_MAX);
    dis[s] = 0;
    heap.push({s, 0});
}

void addEdge(int u, int v, int w) {
    nexte[++cnt] = head[u];
    head[u] = cnt;
    to[cnt] = v;
    weight[cnt] = w;
}

void dijkstra() {
    init();
    while (!heap.empty()) {
        Node cur = heap.top();
        heap.pop();
        if (!vis[cur.u]) {
            vis[cur.u] = true;
            for (int i = head[cur.u]; i > 0; i = nexte[i]) {
                if (dis[to[i]] > cur.w + weight[i]) {
                    dis[to[i]] = cur.w + weight[i];
                    heap.push({to[i], dis[to[i]]});
                }
            }
        }
    }
}

int main() {
    cin >> n >> m >> s;
    for (int i = 0, u, v, w; i < m; i++) {
        cin >> u >> v >> w;
        addEdge(u, v, w);
    }
    dijkstra();
    for (int i = 1; i <= n; i++) cout << dis[i] << " ";
    return 0;
}