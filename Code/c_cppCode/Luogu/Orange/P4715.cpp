#include <iostream>
using namespace std;

const int MAX_N = 8;

int n;
pair<int, int> cty[1 << MAX_N];

int main() {
    cin >> n;
    for (int i = 0; i < (1 << n); i++) {
        cin >> cty[i].first;
        cty[i].second = i + 1;
    }
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0, k = 0; k < (1 << (n - i)); j++, k += 2) {
            cty[j] = cty[k].first > cty[k + 1].first ? cty[k] : cty[k + 1];
        }
    }
    cout << (cty[0].first > cty[1].first ? cty[1].second : cty[0].second);
    return 0;
}