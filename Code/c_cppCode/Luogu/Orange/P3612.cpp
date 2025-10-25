#include <cmath>
#include <iostream>
using namespace std;

string s;
unsigned long long N;

long long quickPow(long long a, long long b) {
    long long p = a;
    long long res = 1;
    while (b) {
        if (b & 1) res *= p;
        b >>= 1;
        p *= p;
    }
    return res;
}

long long quickLog2(long long a) {
    long long res = 0;
    while (a >>= 1) {
        res++;
    }
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin >> s >> N;
    unsigned long long l;
    while (N > s.length()) {
        l = s.length();
        while (l < N) l *= 2;
        N = N - l / 2 - 1 > 0 ? N - l / 2 - 1 : l / 2;
        // l = quickPow(2, quickLog2(N / s.length())) * s.length();
        // N = N - l - 1 > 0 ? N - l - 1 : l;
    }
    cout << s[N - 1];
    return 0;
}