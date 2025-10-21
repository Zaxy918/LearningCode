#include <algorithm>
#include <iomanip>
#include <iostream>
using namespace std;

const int MAX_N = 9;

int n;
int nums[MAX_N];
bool vst[MAX_N];

void dfs(int d) {
    if (d == n) {
        for_each(nums, nums + d, [](int num) { cout << setw(5) << num; });
        cout << endl;
    }
    for (int i = 1; i <= n; i++) {
        if (!vst[i]) {
            vst[i] = true;
            nums[d] = i;
            dfs(d + 1);
            vst[i] = false;
        }
    }
}

int main() {
    cin >> n;
    dfs(0);
    return 0;
}