#include <iostream>
#include <map>
using namespace std;

const int MAX_N = 302;
const int MOVE[5] = {-1, 0, 1, 0, -1};

char maze[MAX_N][MAX_N];
bool vis[MAX_N][MAX_N];
int n, m;
int sx, sy;
map<char, pair<pair<int, int>, pair<int, int>>> port;
int q[MAX_N * MAX_N][2];
int h, t;
int res;

void bfs() {
    while (h < t) {
        res++;
        int size = t - h;
        for (int i = 0, curX, curY; i < size; i++) {
            curX = q[h][0];
            curY = q[h++][1];
            for (int j = 0, dx, dy; j < 4; j++) {
                dx = curX + MOVE[j];
                dy = curY + MOVE[j + 1];
                if (dx > 0 && dy > 0 && dx <= n && dy <= m && !vis[dx][dy] && maze[dx][dy] != '#') {
                    if (maze[dx][dy] == '=') {
                        cout << res;
                        return;
                    }
                    if (isalpha(maze[dx][dy])) {
                        int tx = dx, ty = dy;
                        if (tx == port[maze[dx][dy]].first.first && ty == port[maze[dx][dy]].first.second) {
                            tx = port[maze[dx][dy]].second.first;
                            ty = port[maze[dx][dy]].second.second;
                        } else {
                            tx = port[maze[dx][dy]].first.first;
                            ty = port[maze[dx][dy]].first.second;
                        }
                        q[t][0] = tx;
                        q[t++][1] = ty;
                        vis[dx][dy] = true;
                    } else {
                        q[t][0] = dx;
                        q[t++][1] = dy;
                        vis[dx][dy] = true;
                    }
                }
            }
        }
    }
}

int main() {
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> maze[i][j];
            if (maze[i][j] == '@') {
                q[t][0] = i;
                q[t++][1] = j;
            } else if (isalpha(maze[i][j])) {
                if (!port.count(maze[i][j])) {
                    port[maze[i][j]].first = {i, j};
                } else {
                    port[maze[i][j]].second = {i, j};
                }
            }
        }
    }
    bfs();
    return 0;
}