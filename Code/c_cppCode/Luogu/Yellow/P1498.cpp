#include <cmath>
#include <iostream>
using namespace std;

const int MAX_R = 1 << 10;
const int MAX_C = 1 << 11;

int n;
char graph[MAX_R][MAX_C];

void dfs(int n, int x, int y) {
    if (n == 1) {
        graph[x][y] = '/';
        graph[x][y + 1] = '_';
        graph[x][y + 2] = '_';
        graph[x][y + 3] = '\\';
        graph[x - 1][y + 1] = '/';
        graph[x - 1][y + 2] = '\\';
        return;
    }
    dfs(n - 1, x - (1 << (n - 1)), y + (1 << (n - 1)));
    dfs(n - 1, x, y);
    dfs(n - 1, x, y + (1 << n));
}

int main() {
    cin >> n;
    dfs(n, (1 << n) - 1, 0);
    for (int i = 0; i < (1 << n); i++) {
        for (int j = 0; j < ((1 << n) + 1 + i); j++) {
            if (graph[i][j]) {
                cout << graph[i][j];
            } else {
                cout << " ";
            }
        }
        cout << endl;
    }
    return 0;
}