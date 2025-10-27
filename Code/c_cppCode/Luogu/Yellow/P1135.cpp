#include <iostream>
using namespace std;

const int MAX_N = 201;

int n, a, b, cnt;
int k[MAX_N];
int q[MAX_N * MAX_N];
int h, t;
bool vis[MAX_N];
bool isArrive;

void bfs() {
    while (h < t) {
        int cur;
        int size = t - h;
        cnt++;
        for (int i = 0, up, down; i < size; i++) {
            cur = q[h++];
            up = cur + k[cur];
            down = cur - k[cur];
            if (up == b) {
                isArrive = true;
                cout << cnt;
                exit(0);
            }
            if (down == b) {
                isArrive = true;
                cout << cnt;
                exit(0);
            }
            if (up > 0 && up <= n && !vis[up]) {
                q[t++] = up;
                vis[up] = true;
            }
            if (down > 0 && down <= n && !vis[down]) {
                q[t++] = down;
                vis[down] = true;
            }
        }
    }
}

int main() {
    cin >> n >> a >> b;
    if (a == b) {
        cout << 0;
        return 0;
    }
    for (int i = 1; i <= n; i++) {
        cin >> k[i];
    }
    q[t++] = a;
    vis[a] = true;
    bfs();
    if (!isArrive) cout << -1;
    return 0;
}