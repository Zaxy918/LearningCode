#include <algorithm>
#include <cmath>
#include <iostream>
using namespace std;

const int MAX_N = 50001;

int N;
double sum;
struct Position {
    double x, y, z;
} pos[MAX_N];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) cin >> pos[i].x >> pos[i].y >> pos[i].z;
    sort(pos, pos + N, [](Position a, Position b) { return a.z < b.z; });
    for (int i = 1; i < N; i++) {
        sum += sqrtl(powl((pos[i].x - pos[i - 1].x), 2) + pow((pos[i].y - pos[i - 1].y), 2) + pow((pos[i].z - pos[i - 1].z), 2));
    }
    printf("%.3lf", sum);
    return 0;
}