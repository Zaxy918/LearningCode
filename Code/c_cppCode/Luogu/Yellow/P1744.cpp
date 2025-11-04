#include <climits>
#include <cmath>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 101;
const int MAX_M = 2 * 1001;

struct Node {
    int u;
    double w;
    bool operator<(const Node &other) const {
        return this->w > other.w;
    }
};
int n, m;
double x, y;
int s, t;
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
int cnt;
double pos[MAX_N][2];
double weight[MAX_M];
double dis[MAX_M];
bool vis[MAX_N];
priority_queue<Node> heap;

double eulerDis(double x1, double y1, double x2, double y2) {
    return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
}

void addEdge(int u, int v, double w) {
    nexte[++cnt] = head[u];
    head[u] = cnt;
    to[cnt] = v;
    weight[cnt] = w;
}

void dijkstra() {
    fill(dis + 1, dis + n + 1, INT_MAX);
    dis[s] = 0;
    heap.push({s, dis[s]});
    while (!heap.empty()) {
        Node cur = heap.top();
        heap.pop();
        if (cur.u == t) return;
        if (!vis[cur.u]) {
            vis[cur.u] = true;
            for (int i = head[cur.u]; i > 0; i = nexte[i]) {
                if (dis[cur.u] + weight[i] < dis[to[i]]) {
                    dis[to[i]] = dis[cur.u] + weight[i];
                    heap.push({to[i], dis[to[i]]});
                }
            }
        }
    }
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> pos[i][0] >> pos[i][1];
    }
    cin >> m;
    for (int i = 0, u, v; i < m; i++) {
        cin >> u >> v;
        double w = eulerDis(pos[u][0], pos[u][1], pos[v][0], pos[v][1]);
        addEdge(u, v, w);
        addEdge(v, u, w);
    }
    cin >> s >> t;
    dijkstra();
    printf("%.2f", dis[t]);
    return 0;
}