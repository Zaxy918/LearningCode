#include <cmath>
#include <iostream>
using namespace std;

const int CARPET_TYPE[2][2] = {
    {4, 3},
    {2, 1}};
const int CARPET_POS[4][2] = {
    {1, 1},
    {1, 0},
    {0, 1},
    {0, 0}};

int k, x, y;

void dfs(int d, int x, int y, int bx, int by) {
    if (d == 0) {
        return;
    }
    int ofst = pow(2, d - 1);
    int mx = bx - ofst, my = by - ofst;
    int px = x <= mx, py = y <= my;
    int tp = CARPET_TYPE[px][py];
    cout << mx + CARPET_POS[tp - 1][0] << " " << my + CARPET_POS[tp - 1][1] << " " << tp << endl;
    if (px && py) {
        dfs(d - 1, x, y, mx, my);
        dfs(d - 1, mx, my + 1, mx, by);
        dfs(d - 1, mx + 1, my, bx, my);
        dfs(d - 1, mx + 1, my + 1, bx, by);
    }
    if (px && !py) {
        dfs(d - 1, mx, my, mx, my);
        dfs(d - 1, x, y, mx, by);
        dfs(d - 1, mx + 1, my, bx, my);
        dfs(d - 1, mx + 1, my + 1, bx, by);
    }
    if (!px && py) {
        dfs(d - 1, mx, my, mx, my);
        dfs(d - 1, mx, my + 1, mx, by);
        dfs(d - 1, x, y, bx, my);
        dfs(d - 1, mx + 1, my + 1, bx, by);
    }
    if (!px && !py) {
        dfs(d - 1, mx, my, mx, my);
        dfs(d - 1, mx, my + 1, mx, by);
        dfs(d - 1, mx + 1, my, bx, my);
        dfs(d - 1, x, y, bx, by);
    }
}

int main() {
    cin >> k;
    cin >> x >> y;
    dfs(k, x, y, 1 << k, 1 << k);
    return 0;
}