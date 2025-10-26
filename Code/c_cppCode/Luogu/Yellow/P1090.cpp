#include <iostream>
#include <queue>
using namespace std;

const int MAX_N = 10001;

int n, res, asis;
priority_queue<int, vector<int>, greater<int>> a;

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        a.push(tmp);
    }
    for (int i = 0; i < n - 1; i++) {
        asis = 0;
        asis += a.top();
        a.pop();
        asis += a.top();
        a.pop();
        a.push(asis);
        res += asis;
    }
    cout << res;
    return 0;
}