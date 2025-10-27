#include <iostream>
using namespace std;

const int MAX_N = 401;
const int MOVE[8][2] = {
    {-2, 1},
    {-1, 2},
    {1, 2},
    {2, 1},
    {2, -1},
    {1, -2},
    {-1, -2},
    {-2, -1}};

int n, m, x, y;
int pos[MAX_N][MAX_N];
int q[MAX_N * MAX_N][2];
int h, t;
int cnt;

int main() {
    cin >> n >> m >> x >> y;
    for (int i = 0; i < MAX_N; i++) {
        fill(pos[i], pos[i] + MAX_N, -1);
    }
    pos[x - 1][y - 1] = 0;
    q[t][0] = x - 1;
    q[t++][1] = y - 1;
    while (h < t) {
        cnt++;
        int size = t - h;
        for (int i = 0, curX, curY; i < size; i++) {
            curX = q[h][0];
            curY = q[h++][1];
            for (int j = 0, dx, dy; j < 8; j++) {
                dx = curX + MOVE[j][0];
                dy = curY + MOVE[j][1];
                if (dx >= 0 && dy >= 0 && dx < n && dy < m && pos[dx][dy] == -1) {
                    q[t][0] = dx;
                    q[t++][1] = dy;
                    pos[dx][dy] = cnt;
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << pos[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}