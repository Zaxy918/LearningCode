#include <iostream>
using namespace std;

const int MAX_RC = 101;

int R, C, K;
char court[MAX_RC][MAX_RC];
int cnt;

bool isValidR(int r, int c) {
    int offset = 0;
    while (offset < K) {
        if (court[r][c + offset] == '#') return false;
        offset++;
    }
    return true;
}

bool isValidC(int r, int c) {
    int offset = 0;
    while (offset < K) {
        if (court[r + offset][c] == '#') return false;
        offset++;
    }
    return true;
}

int main() {
    cin >> R >> C >> K;
    for (int i = 0; i < R; i++) court[i][C] = '#';
    for (int i = 0; i < C; i++) court[R][i] = '#';
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> court[i][j];
        }
    }
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (court[i][j] == '.') {
                if (K != 1) {
                    if (isValidR(i, j)) cnt++;
                    if (isValidC(i, j)) cnt++;
                } else
                    cnt++;
            }
        }
    }
    cout << cnt;
    return 0;
}