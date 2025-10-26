#include <iostream>
using namespace std;

const int MAX_N = 1e6 + 1;
const int MAX_M = 1e5 + 1;

int n, m;
int arr[MAX_N], opt[MAX_M];

int main() {
    ios::sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    for (int i = 0; i < m; i++) {
        cin >> opt[i];
    }
    for (int i = 0; i < m; i++) {
        int num = opt[i];
        if (num < arr[0] || num > arr[n - 1]) {
            cout << -1 << " ";
            continue;
        }
        int l = 0, r = n;
        int mid;
        while (l < r) {
            mid = (r + l) / 2;
            if (arr[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == num)
            cout << l + 1 << " ";
        else
            cout << -1 << " ";
    }
    return 0;
}