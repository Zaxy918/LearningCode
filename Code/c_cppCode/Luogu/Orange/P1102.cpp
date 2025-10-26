#include <algorithm>
#include <iostream>
#include <map>
using namespace std;

const int MAX_N = 2 * 1e5 + 1;

int n;
long long res, c, nums[MAX_N];
map<int, int> cnts;

int main() {
    cin >> n >> c;
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
        cnts[nums[i]]++;
    }
    sort(nums, nums + n, greater<int>());
    for (int i = 0; nums[i] > c && i < n; i++) {
        int num = nums[i];
        res += num - c > 0 ? binary_search(nums, nums + n, num - c) >= 0 ? cnts[num - c] : 0 : 0;
    }
    cout << res;
    return 0;
}