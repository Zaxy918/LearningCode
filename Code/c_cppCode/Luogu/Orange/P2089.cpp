#include <iostream>
using namespace std;

const int MAX_F = 10;
const int MAX_S = 10000;

int n, solus;
int favors[MAX_S][MAX_F];

void dfs(int d, int dilicious) {
    if (d == MAX_F) {
        if (dilicious == n) {
            solus++;
            for (int i = 0; i < d; i++) {
                favors[solus][i] = favors[solus - 1][i];
            }
            return;
        } else {
            return;
        }
    }
    for (int i = 1; i <= 3; i++) {
        if (dilicious + i <= n) {
            favors[solus][d] = i;
            dfs(d + 1, dilicious + i);
        }
    }
}

int main() {
    cin >> n;
    if (n > 30 || n < 10) {
        cout << 0;
    } else {
        dfs(0, 0);
        cout << solus << endl;
        for (int i = 0; i < solus; i++) {
            for (int j = 0; j < MAX_F; j++) {
                cout << favors[i][j] << " ";
            }
            cout << endl;
        }
    }
    return 0;
}