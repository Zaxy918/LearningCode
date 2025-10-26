#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 101;

int N;
double T, sum;
struct Gold {
    double m, v;
} gold[MAX_N];

int main() {
    cin >> N >> T;
    for (int i = 0; i < N; i++) {
        cin >> gold[i].m >> gold[i].v;
    }
    sort(gold, gold + N, [](Gold a, Gold b) { return a.v / a.m > b.v / b.m; });
    for (int i = 0; (i < N) && T; i++) {
        if (gold[i].m <= T) {
            sum += gold[i].v;
            T -= gold[i].m;
        } else {
            sum += T * gold[i].v / gold[i].m;
            T = 0;
        }
    }
    printf("%.2lf", sum);
    return 0;
}