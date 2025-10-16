#include <iostream>
using namespace std;

const int MAX_N = 10010;

bool vst[MAX_N];
int primes[MAX_N];
int cnt;

void Eratosthenes() {
    for (int i = 0; i < MAX_N; i++) {
        if (i < 2) {
            vst[i] = true;
            continue;
        }
        if (!vst[i]) {
            primes[cnt++] = i;
        }
    }
}