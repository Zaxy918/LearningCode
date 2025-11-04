/*
 * We must run spfa from 1 and n instead of start from a virtual node 0.
 * If the real ans is above 0, the first way is wrong.
 */
#include <climits>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 1e3 + 1;
const int MAX_M = 1e4 + 1;

int n, m;
int head[MAX_N];
int nexte[MAX_M];
int to[MAX_M];
int weight[MAX_M];
int cnt;
queue<int> q;
bool enter[MAX_N];
int rlxCnt[MAX_N];
int dis[MAX_N];

void addEdge(int u, int v, int w) {
    nexte[++cnt] = head[u];
    head[u] = cnt;
    to[cnt] = v;
    weight[cnt] = w;
}

void init(int s) {
    fill(dis + 1, dis + n + 1, INT_MAX);
    fill(enter + 1, enter + n + 1, false);
    q.push(s);
    dis[s] = 0;
    enter[s] = true;
}

bool spfa(int s) {
    init(s);
    while (!q.empty()) {
        int u = q.front();
        q.pop(), enter[u] = false;
        for (int i = head[u]; i > 0; i = nexte[i]) {
            if (dis[u] + weight[i] < dis[to[i]]) {
                dis[to[i]] = dis[u] + weight[i];
                if (!enter[to[i]]) {
                    if (++rlxCnt[to[i]] >= n) return true;
                    q.push(to[i]), enter[to[i]] = true;
                }
            }
        }
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0, s, t, w; i < m; i++) {
        cin >> s >> t >> w;
        addEdge(s, t, -w);
    }
    if (spfa(1)) {
        cout << "Forever love" << endl;
    } else {
        int ans = dis[n];
        spfa(n);
        cout << min(ans, dis[1]);
    }
    return 0;
}