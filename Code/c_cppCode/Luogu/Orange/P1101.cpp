#include <iostream>
#include <vector>
using namespace std;

const int MAX_N = 101;
const char yizhong[8] = "yizhong";

int n;
char block[MAX_N][MAX_N];
vector<vector<pair<int, int>>> path(MAX_N *MAX_N);
int q[MAX_N * MAX_N][2];
int h, t;

void bfs() {
}

int main() {
    cin >> n;
    for (int i = 0; i < n * n; i++) {
        cin >> block[i / 10][i % 10];
        if (block[i / 10][i % 10] == 'y') {
            q[t][0] = i / 10;
            q[t++][1] = i % 10;
            path[i].push_back({i / 10, i % 10});
        }
    }
    return 0;
}