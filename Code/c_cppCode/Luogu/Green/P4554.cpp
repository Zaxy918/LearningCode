// 01bfs, a specifiction of dijkstra.Node in deque only have two kinds of distance from source.
#include <climits>
#include <deque>
#include <iostream>

const int MAX_N = 501;
const int MOVE[5] = {-1, 0, 1, 0, -1};

int n, m;
int x1, Y1, x2, y2;
char graph[MAX_N][MAX_N];
int dis[MAX_N][MAX_N];

int bfs() {
    std::deque<std::pair<int, int>> dq;
    for (int i = 0; i < n; i++) std::fill(dis[i], dis[i] + m, INT_MAX);
    dis[x1][Y1] = 0;
    dq.push_front({x1, Y1});
    while (!dq.empty()) {
        int curX = dq.front().first;
        int curY = dq.front().second;
        dq.pop_front();
        if (curX == x2 && curY == y2) return dis[x2][y2];
        for (int j = 0, dx, dy, w; j < 4; j++) {
            dx = curX + MOVE[j];
            dy = curY + MOVE[j + 1];
            if (dx >= 0 && dy >= 0 && dx < n && dy < m) {
                w = graph[dx][dy] == graph[curX][curY] ? 0 : 1;
                if (dis[curX][curY] + w < dis[dx][dy]) { // If change, go to the deque.No need to have visArr.
                    dis[dx][dy] = dis[curX][curY] + w;
                    w ? dq.push_back({dx, dy}) : dq.push_front({dx, dy});
                }
            }
        }
    }
    return -1;
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    while (std::cin >> n >> m && n != 0 && m != 0) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                std::cin >> graph[i][j];
            }
        }
        std::cin >> x1 >> Y1 >> x2 >> y2;
        std::cout << bfs() << std::endl;
    }
    return 0;
}