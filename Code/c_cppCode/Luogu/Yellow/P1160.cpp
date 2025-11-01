#include <algorithm>
#include <iostream>
#include <list>
using namespace std;

const int MAX_N = 1e5 + 2;

int n, m;
list<int> q;
list<int>::iterator its[MAX_N];
bool exist[MAX_N];

int main() {
    cin >> n;
    fill(exist + 1, exist + n + 1, true);
    q.push_back(1);
    its[1] = q.begin();
    for (int i = 2, k, p; i <= n; i++) {
        cin >> k >> p;
        if (p) {
            auto nextIt = next(its[k]);
            its[i] = q.insert(nextIt, i);
        } else {
            its[i] = q.insert(its[k], i);
        }
    }
    cin >> m;
    for (int i = 0, x; i < m; i++) {
        cin >> x;
        if (exist[x]) {
            q.erase(its[x]);
            exist[x] = false;
        }
    }
    for_each(q.begin(), q.end(), [](int i) { cout << i << " "; });
    return 0;
}