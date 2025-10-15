#include <climits>
#include <cmath>
#include <iostream>
#include <map>
using namespace std;

int minn = INT_MAX;
int maxn = 1;
string str;
map<char, int> mp;

bool isPrime(int n) {
    if (n < 2)
        return false;
    if (n == 2)
        return true;
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}

int main() {
    cin >> str;
    for (char c : str) {
        mp[c]++;
    }
    for (auto p : mp) {
        maxn = maxn > p.second ? maxn : p.second;
        minn = minn < p.second ? minn : p.second;
    }
    if (isPrime(maxn - minn)) {
        cout << "Lucky Word" << endl;
        cout << maxn - minn << endl;
    } else {
        cout << "No Answer\n0" << endl;
    }
    return 0;
}