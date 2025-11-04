#include <iostream>
#include <queue>
#include <vector>
using namespace std;
class Solution {
  public:
    struct Node {
        int id, w, st;
        bool operator<(const Node &other) const {
            return this->w > other.w;
        }
    };
    static const int MAX_N = 101;
    static const int MAX_M = 401;
    static const int MAX_P = 101;
    int head[MAX_N];
    int nexte[MAX_M];
    int to[MAX_M];
    int weight[MAX_M];
    int cnte;
    int vis[MAX_N][MAX_P];
    int dis[MAX_N][MAX_P];
    priority_queue<Node> heap;

    void addEdge(int u, int v, int w) {
        nexte[++cnte] = head[u];
        to[cnte] = v;
        head[u] = cnte;
        weight[cnte] = w;
    }

    int electricCarPlan(vector<vector<int>> &paths, int cnt, int start, int end, vector<int> &charge) {
        for (int i = 0; i < paths.size(); i++) {
            addEdge(paths[i][0], paths[i][1], paths[i][2]);
            addEdge(paths[i][1], paths[i][0], paths[i][2]);
        }
        for (int i = 0; i < charge.size(); i++) {
            for (int j = 0; j <= cnt; j++) {
                dis[i][j] = INT_MAX;
            }
        }
        dis[start][0] = 0;
        heap.push({start, 0, 0});
        while (!heap.empty()) {
            Node cur = heap.top();
            heap.pop();
            if (cur.id == end) return cur.w;
            if (!vis[cur.id][cur.st]) {
                vis[cur.id][cur.st] = true;
                if (cur.st < cnt) {
                    if (!vis[cur.id][cur.st + 1] && cur.w + charge[cur.id] < dis[cur.id][cur.st + 1]) {
                        dis[cur.id][cur.st + 1] = cur.w + charge[cur.id];
                        heap.push({cur.id, dis[cur.id][cur.st + 1], cur.st + 1});
                    }
                }
                for (int i = head[cur.id], curDis; i > 0; i = nexte[i]) {
                    if (cur.st >= weight[i]) {
                        curDis = dis[cur.id][cur.st] + weight[i];
                        if (!vis[to[i]][cur.st - weight[i]] && curDis < dis[to[i]][cur.st - weight[i]]) {
                            dis[to[i]][cur.st - weight[i]] = curDis;
                            heap.push({to[i], curDis, cur.st - weight[i]});
                        }
                    }
                }
            }
        }
        return -1;
    }
};
int main() {
    Solution sl;
    // Enter the following args to test:
    vector<vector<int>> paths = {{1, 3, 3}, {3, 2, 1}, {2, 1, 3}, {0, 1, 4}, {3, 0, 5}};
    int cnt = 6, start = 1, end = 0;
    vector<int> charge = {2, 10, 4, 1};
    cout << sl.electricCarPlan(paths, cnt, start, end, charge) << endl;
}