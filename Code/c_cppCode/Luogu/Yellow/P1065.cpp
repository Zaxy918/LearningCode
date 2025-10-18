#include <climits>
#include <cstring>
#include <iostream>
using namespace std;

const int MAX_A = 21;

int m, n;
int wkmc[MAX_A][MAX_A];
int wktm[MAX_A][MAX_A];
int wkod[MAX_A * MAX_A];
int wkpcd[MAX_A];
int lastpcdtm[MAX_A];
int mctm[MAX_A][MAX_A * MAX_A];
int restm[MAX_A];
int res = 0;

int main() {
    fill(wkpcd, wkpcd + MAX_A, 1);
    cin >> m >> n;
    for (int i = 1; i <= m * n; i++) {
        cin >> wkod[i];
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> wkmc[i][j];
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> wktm[i][j];
        }
    }
    for (int i = 1; i <= m * n; i++) {
        int item = wkod[i];
        int pcd = wkpcd[item];
        int mc = wkmc[item][pcd];
        int time = wktm[item][pcd];
        for (int j = lastpcdtm[item] + 1; j < MAX_A * MAX_A; j++) {
            bool canwk = true;
            for (int k = j; k < j + time; k++) {
                if (mctm[mc][k] != 0) {
                    canwk = false;
                    break;
                }
            }
            if (canwk) {
                fill(&mctm[mc][j], &mctm[mc][j + time], 1);
                lastpcdtm[item] = j + time - 1;
                restm[mc] = max(restm[mc], lastpcdtm[item]);
                wkpcd[item]++;
                break;
            }
        }
    }
    for (int i = 1; i <= m; i++) {
        res = max(restm[i], res);
    }
    cout << res;
    return 0;
}