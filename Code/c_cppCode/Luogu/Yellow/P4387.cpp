#include <iostream>
#include <stack>
using namespace std;

const int MAX_N = 1e5;

int q, n;
int pushed[MAX_N];
int poped[MAX_N];
stack<int> stk;

int main() {
    cin >> q;
    while (q--) {
        cin >> n;
        for (int i = 0; i < n; i++) cin >> pushed[i];
        for (int i = 0; i < n; i++) cin >> poped[i];
        for (int i = 0, j = 0; i < n; i++) {
            stk.push(pushed[i]);
            while (!stk.empty() && stk.top() == poped[j]) {
                j++;
                stk.pop();
            }
        }
        if (stk.empty())
            cout << "Yes" << endl;
        else {
            while (!stk.empty()) stk.pop();
            cout << "No" << endl;
        }
    }
    return 0;
}