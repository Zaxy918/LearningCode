#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

const int MAX_N = 13;

int n;
int res;
vector<int> pos;

void dfs(int limit, int c, int lu, int ru) {
    if (limit == c) {
        if (res < 3) {
            for_each(pos.begin(), pos.end(), [](int p) { cout << p << " "; });
            cout << endl;
        }
        res++;
        return;
    }
    int ban = c | lu | ru;
    int can = limit & (~ban);
    int p;
    while (can) {
        p = can & (-can);
        can ^= p;
        if (res <= 3)
            pos.push_back(log2(p) + 1);
        dfs(limit, c | p, (lu | p) >> 1, (ru | p) << 1);
        if (res <= 3)
            pos.pop_back();
    }
}

int main() {
    cin >> n;
    dfs((1 << n) - 1, 0, 0, 0);
    cout << res;
    return 0;
}