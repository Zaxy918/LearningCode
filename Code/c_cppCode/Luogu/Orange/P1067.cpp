#include <iostream>
using namespace std;

const int MAX_N = 101;

int n;
int ef[MAX_N];

int main() {
    cin >> n;
    for (int i = 0; i <= n; i++) {
        cin >> ef[i];
    }
    for (int i = 0; i <= n; i++) {
        cout << (ef[i] == 0 ? "" : (n == 0 ? to_string(ef[i]) : (i == 0 ? (ef[i] == 1 ? "" : (ef[i] == -1 ? "-" : to_string(ef[i]))) : (i == n ? (ef[i] > 0 ? ("+" + to_string(ef[i])) : to_string(ef[i])) : (ef[i] == 1 ? "+" : (ef[i] == -1 ? "-" : (ef[i] > 0 ? ("+" + to_string(ef[i])) : to_string(ef[i])))))))) << (i < n ? (ef[i] == 0 ? "" : "x" + (n - i == 1 ? "" : "^" + to_string(n - i))) : "");
    }
    return 0;
}