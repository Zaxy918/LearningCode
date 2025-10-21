#include <algorithm>
#include <climits>
#include <iostream>
using namespace std;

const char COLOR[3] = {'W', 'B', 'R'};
const int MAX_MN = 51;

int N, M;
int cnt = INT_MAX;
char flag[MAX_MN][MAX_MN];

int cntBlocks(int bi, int ri) {
    int tmpCnt = 0;
    for (int i = 0; i < bi; i++) {
        for_each(flag[i], flag[i] + M, [&tmpCnt](char c) { if(c != 'W') tmpCnt++; });
    }
    for (int i = bi; i < ri; i++) {
        for_each(flag[i], flag[i] + M, [&tmpCnt](char c) { if(c != 'B') tmpCnt++; });
    }
    for (int i = ri; i < N; i++) {
        for_each(flag[i], flag[i] + M, [&tmpCnt](char c) { if(c != 'R') tmpCnt++; });
    }
    return tmpCnt;
}

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> flag[i][j];
        }
    }
    for (int i = 1; i < N - 1; i++) {
        for (int j = i + 1; j < N; j++) {
            cnt = min(cnt, cntBlocks(i, j));
        }
    }
    cout << cnt;
    return 0;
}