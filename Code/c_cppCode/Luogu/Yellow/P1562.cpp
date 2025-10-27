#include <iostream>
using namespace std;

const int MAX_N = 15;

int N;
int by[MAX_N];
int res;

void dfs(int limit, int x, int c, int lu, int ru) {
    if (c == limit) {
        res++;
        return;
    }
    int ban = c | lu | ru | by[x];
    int can = limit & (~ban);
    int p;
    while (can) {
        p = can & (-can);
        can ^= p;
        dfs(limit, x + 1, c | p, (lu | p) >> 1, (ru | p) << 1);
    }
}

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 1; j < (1 << N); j <<= 1) {
            char temp;
            cin >> temp;
            if (temp == '.') {
                by[i] |= j;
            }
        }
    }
    dfs((1 << N) - 1, 0, 0, 0, 0);
    cout << res;
    return 0;
}