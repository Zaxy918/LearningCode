#include <climits>
#include <iostream>
#include <queue>
using namespace std;

const int MAX_C = 301;

int d, p, c, f;
int res;
int graph[MAX_C][MAX_C];
int dis[MAX_C];
queue<int> q;
bool enter[MAX_C];
int relaxCnt[MAX_C];

bool spfa() {
    fill(dis, dis + c + 1, INT_MAX);
    while (!q.empty()) q.pop();
    dis[0] = 0;
    q.push(0);
    enter[0] = true;
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        enter[u] = false;
        for (int i = 1; i <= c; i++) {
            if (graph[u][i] != INT_MAX && dis[u] + graph[u][i] < dis[i]) {
                dis[i] = dis[u] + graph[u][i];
                if (!enter[i]) {
                    if (++relaxCnt[i] >= c) return true;
                    q.push(i);
                    enter[i] = true;
                }
            }
        }
    }
    return false;
}

int main() {
    cin >> d >> p >> c >> f;
    for (int i = 1; i <= c; i++) fill(graph[i] + 1, graph[i] + c + 1, INT_MAX);
    for (int i = 0, a, b; i < p; i++) {
        cin >> a >> b;
        graph[a][b] = -d;
    }
    for (int i = 0, j, k, t; i < f; i++) {
        cin >> j >> k >> t;
        graph[j][k] = t - d;
    }
    for (int i = 1; i <= c; i++) {
        graph[0][i] = -d; // A visual start to reach every node
    }
    if (spfa()) {
        cout << "orz";
    } else {
        for (int i = 1; i <= c; i++) res = min(dis[i], res);
        cout << -res;
    }
    return 0;
}