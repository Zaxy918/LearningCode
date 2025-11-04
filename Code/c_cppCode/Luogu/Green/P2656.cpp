#include <climits>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 8 * 1e4 + 1;
const int MAX_M = 2 * 1e5 + 1;

struct Node {
    int u, w;
    bool operator<(const Node &other) const {
        return this->w > other.w;
    }
};
int n, m, s;
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
int weight[MAX_M];
double ratio[MAX_M];
int cnt;
int dis[MAX_N];
priority_queue<Node> heap;

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
}

void dijkstra() {
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0, u, v, w, r; i < m; i++) {
        cin >> u >> v >> w >> r;
        addEdge(u, v, -w, r);
    }
    cin >> s;
    return 0;
}