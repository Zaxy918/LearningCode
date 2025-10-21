#include <algorithm>
#include <iostream>
#include <set>
using namespace std;

int N;
set<int> res;

int main() {
    ios::sync_with_stdio(false);
    cin >> N;
    for (int i = 0; i < N; i++) {
        int tmp;
        cin >> tmp;
        res.insert(tmp);
    }
    cout << res.size() << endl;
    for_each(res.begin(), res.end(), [](int n) { cout << n << " "; });
    return 0;
}