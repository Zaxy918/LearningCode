#include <iostream>
using namespace std;

const int MAX_NM = 501;

int n, m;
int block[MAX_NM][MAX_NM];
int asist[MAX_NM][MAX_NM];

void initialArr(int x) {
    for (int i = 0; i < x * x; i++) {
        block[i / x][i % x] = i + 1;
        asist[i / x][i % x] = i + 1;
    }
}

void rotate(int x, int y, int r, int z) {
    int sx = x - r;
    int sy = y - r;
    int ex = x + r;
    int ey = y + r;
    for (int i = sx; i <= ex; i++) {
        for (int j = sy; j <= ey; j++) {
            if (z) {
                asist[x + y - j][y - x + i] = block[i][j];
            } else {
                asist[x - y + j][x + y - i] = block[i][j];
            }
        }
    }
    for (int i = sx; i <= ex; i++) {
        for (int j = sy; j <= ey; j++) {
            block[i][j] = asist[i][j];
        }
    }
}

int main() {
    cin >> n >> m;
    initialArr(n);
    while (m--) {
        int x, y, r, z;
        cin >> x >> y >> r >> z;
        rotate(x - 1, y - 1, r, z);
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << block[i][j] << " ";
        }
        cout << endl;
    }
}