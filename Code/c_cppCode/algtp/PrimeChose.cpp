#include <iostream>
using namespace std;

const int MAX_N = 10010;

bool vst[MAX_N]; // Initially all false, consumes that all numbers are primitive.
int primes[MAX_N];
int cnt;

/*
 *
 * Eratosthenes:
 *      If a number is peimitive, visit all it's multiple from i * i. But for numbers with multiple primitive divider
 * like 6 = 2 * 3, they will be visited multiple times.So the euler is better.The euler only visit the number when the
 * current prime is the smallest divider.
 *
 */
void ertthn(int n) { // O(nloglogsqrt(n))
    vst[0] = vst[1] = true;
    for (int i = 2 /*Start from 2*/; i * i <= n /*No need to traversal all*/; i++) {
        if (!vst[i]) { // If the current number is primitive.
            primes[cnt++] = i;
            for (int j = i * i /*Start from i * i. Because the m * i (m < i) must be visitd before i*/; j < n; j += i) { // Visit all numbers that is the current number's multiple.
                vst[j] = true;
            }
        }
    }
}

void euler(int n) { // O(n)
    vst[0] = vst[1] = true;
    for (int i = 2; i < n; i++) {
        if (!vst[i])
            primes[cnt++] = i;
        for (int j = 0; i * primes[j] < n; j++) {
            vst[i * primes[j]] = true;
            if (i % primes[j] == 0)
                break;
        }
    }
}

int main() {
    euler(100);
    for (int i = 0; i < cnt; i++) {
        cout << primes[i] << " ";
    }
}