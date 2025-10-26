#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 1001;

int n;
double wait[MAX_N], res;

struct People {
    double t;
    int od;
} peo[MAX_N];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> peo[i].t;
        peo[i].od = i + 1;
    }
    sort(peo, peo + n, [](People a, People b) { return a.t < b.t; });
    int sum = 0;
    for (int i = 0; i < n; i++) {
        cout << peo[i].od << " ";
        if (i > 0) {
            sum += peo[i - 1].t;
            wait[i] = sum;
        }
    }
    for (int i = 0; i < n; i++) res += wait[i];
    printf("\n%.2lf", res / n);
    return 0;
}