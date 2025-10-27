#include <cstring>
#include <iostream>
#include <vector>
using namespace std;

const int MAX_X = 302;
const int MAX_Y = 302;
const int MAX_T = 1001;
const int MOVE[5] = {-1, 0, 1, 0, -1};

int m, xi, yi, ti;
int cnt;
int q[MAX_X * MAX_Y][2];
int earth[MAX_X][MAX_Y];
bool vis[MAX_X][MAX_Y];
bool isSafe;
int h, t;

void bfs() {
    while (h < t) {
        int size = t - h;
        cnt++;
        for (int i = 0, curX, curY; i < size; i++) {
            curX = q[h][0];
            curY = q[h++][1];
            if (curX > 300 || curY > 300) {
                isSafe = true;
                cout << cnt - 1;
                exit(0);
            }
            for (int j = 0, dx, dy; j < 4; j++) {
                dx = curX + MOVE[j];
                dy = curY + MOVE[j + 1];
                if (dx >= 0 && dy >= 0 && !vis[dx][dy]) {
                    if (earth[dx][dy] == -1) {
                        isSafe = true;
                        cout << cnt;
                        exit(0);
                    }
                    if (earth[dx][dy] > cnt) {
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
    ios::sync_with_stdio(false);
    cin >> m;
    for (int i = 0; i <= MAX_X; i++) {
        for (int j = 0; j <= MAX_Y; j++) {
            earth[i][j] = -1;
        }
    }
    for (int i = 0; i < m; i++) {
        cin >> xi >> yi >> ti;
        if (earth[xi][yi] == -1) earth[xi][yi] = ti;
        for (int j = 0, dx, dy; j < 4; j++) {
            dx = xi + MOVE[j];
            dy = yi + MOVE[j + 1];
            if (dx >= 0 && dy >= 0) {
                if (earth[dx][dy] == -1 || earth[dx][dy] > ti)
                    earth[dx][dy] = ti;
            }
        }
    }
    if (earth[0][0] == -1) {
        cout << 0;
        return 0;
    }
    q[t][0] = 0;
    q[t++][1] = 0;
    bfs();
    if (!isSafe) cout << -1;
    return 0;
}