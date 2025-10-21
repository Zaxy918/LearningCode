#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 101;

int n;
struct People {
    string name;
    int y;
    int m;
    int d;
    int od;
} peo[MAX_N];

int main() {
    ios::sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> peo[i].name >> peo[i].y >> peo[i].m >> peo[i].d;
        peo[i].od = i;
    }
    sort(peo, peo + n, [](People a, People b) { return a.y == b.y ? a.m == b.m ? a.d == b.d ? a.od > b.od : a.d < b.d : a.m < b.m : a.y < b.y; });
    for_each(peo, peo + n, [](People p) { cout << p.name << endl; });
    return 0;
}