#include <algorithm>
#include <cmath>
#include <iostream>
using namespace std;

const int MAX_N = 1001;

int n;
int arr[MAX_N];

int main() {
    cin >> n;
    int pre, cur;
    for (int i = 0; i < n; i++) {
        cin >> cur;
        if (i > 0) arr[i] = abs(cur - pre);
        pre = cur;
    }
    sort(arr + 1, arr + n);
    for (int i = 1; i < n; i++) {
        if (arr[i] != i) {
            cout << "Not jolly";
            return 0;
        }
    }
    cout << "Jolly";
    return 0;
}