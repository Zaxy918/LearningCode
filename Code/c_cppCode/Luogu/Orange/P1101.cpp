#include <iostream>
#include <vector>
using namespace std;

const int MAX_N = 101;
const char yizhong[8] = "yizhong";
const int MOVE[8][2] = {
    {-1, 0},
    {-1, 1},
    {0, 1},
    {1, 1},
    {1, 0},
    {1, -1},
    {0, -1},
    {1, -1}};

int n;
char block[MAX_N][MAX_N];
bool st[MAX_N][MAX_N];
vector<pair<int, int>> path;

void dfs(int d, int x, int y, int dir) {
    if (d == 7) {
        for (auto p : path) {
            st[p.first][p.second] = true;
        }
        return;
    }
    int dx = x + MOVE[dir][0];
    int dy = y + MOVE[dir][1];
    if (dx >= 0 && dy >= 0 && dx < n && dy < n && block[dx][dy] == yizhong[d]) {
        path.push_back({dx, dy});
        dfs(d + 1, dx, dy, dir);
        path.pop_back();
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n * n; i++) {
        cin >> block[i / n][i % n];
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (block[i][j] == 'y') {
                for (int k = 0; k < 8; k++) {
                    path.push_back({i, j});
                    dfs(1, i, j, k);
                    path.pop_back();
                }
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (st[i][j]) {
                cout << block[i][j];
            } else {
                cout << "*";
            }
        }
        cout << endl;
    }
    return 0;
}