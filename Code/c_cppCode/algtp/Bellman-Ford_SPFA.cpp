// P3385
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 2 * 1e3 + 1;
const int MAX_M = 2 * 3 * 1e3 + 1;
const int INF = 0x3f3f3f3f;

int t, n, m;
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
int weight[MAX_M];
int cnt;
queue<int> q;
int dis[MAX_N];
int rlxCnt[MAX_N];
bool enter[MAX_N];

void addEdge(int u, int v, int w) {
    nexte[++cnt] = head[u];
    head[u] = cnt;
    to[cnt] = v;
    weight[cnt] = w;
}

void init() {
    cnt = 0;
    fill(dis + 1, dis + n + 1, INF);
    fill(head + 1, head + n + 1, 0);
    fill(enter + 1, enter + n + 1, false);
    fill(rlxCnt + 1, rlxCnt + n + 1, 0);
    while (!q.empty()) q.pop();
    dis[1] = 0;
    q.push(1);
    enter[1] = true;
}

bool spfa() {
    while (!q.empty()) {
        int cur = q.front();
        q.pop(), enter[cur] = false;
        for (int j = head[cur]; j > 0; j = nexte[j]) {
            if (dis[cur] + weight[j] < dis[to[j]]) {
                dis[to[j]] = dis[cur] + weight[j]; // Relax
                if (!enter[to[j]]) {
                    if (++rlxCnt[to[j]] >= n) return true;
                    q.push(to[j]), enter[to[j]] = true;
                }
            }
        }
    }
    return false;
}

int main() {
    cin >> t;
    while (t--) {
        cin >> n >> m;
        init();
        for (int i = 0, u, v, w; i < m; i++) {
            cin >> u >> v >> w;
            addEdge(u, v, w);
            if (w >= 0) addEdge(v, u, w);
        }
        cout << (spfa() ? "YES" : "NO") << endl;
    }
    return 0;
}