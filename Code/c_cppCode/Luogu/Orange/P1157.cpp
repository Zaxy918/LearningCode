#include <algorithm>
#include <iomanip>
#include <iostream>
using namespace std;

const int MAX_N = 22;

int n, r;
int nums[MAX_N];

void dfs(int d, int idx) {
    if (d == r) {
        for_each(nums, nums + r, [](int num) { cout << setw(3) << num; });
        cout << endl;
    }
    for (int i = idx; i <= n; i++) {
        nums[d] = i;
        dfs(d + 1, i + 1);
    }
}

int main() {
    cin >> n >> r;
    dfs(0, 1);
    return 0;
}