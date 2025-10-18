#include <iostream>
using namespace std;

struct Toy {
    int ori;
    string name;
};

const int MAX_N = 1e5;
const int MAX_M = 1e5;

int n, m;
int cnt;
int idx;
Toy toys[MAX_N];

void moveStep(int ori, int step) {
    int toyOri = toys[idx].ori;
    idx = toyOri == 0 ? (ori == 0 ? ((idx + n - step) % n) : ((idx + step) % n)) : (ori == 0 ? ((idx + step) % n) : ((idx + n - step) % n));
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int ori;
        string name;
        cin >> ori >> name;
        toys[cnt++] = {ori, name};
    }
    while (m--) {
        int ori, step;
        cin >> ori >> step;
        moveStep(ori, step);
    }
    cout << toys[idx].name << endl;
    return 0;
}