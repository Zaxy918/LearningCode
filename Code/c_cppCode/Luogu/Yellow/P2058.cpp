#include <algorithm>
#include <iostream>
#include <map>
#include <queue>
using namespace std;

const int MAX_S = 1e5 + 1;
const int SECS_OF_24H = 86400;
const int MAX_K = 3 * 1e5;

int n;
int distinct;
long long curTime;
int cty24[MAX_S];
struct Ship {
    int t;
    int people_nums;
} ships[MAX_S];
pair<int, int> q[MAX_K];
int h, t;
map<int, int> c2p;

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> ships[i].t >> ships[i].people_nums;
        curTime = ships[i].t - SECS_OF_24H;
        while (h < t) {
            auto s = q[h];
            if (s.first <= curTime) {
                if (--c2p[s.second] == 0) {
                    distinct--;
                }
                h++;
            } else
                break;
        }
        for (int j = 0, ctry; j < ships[i].people_nums; j++) {
            cin >> ctry;
            q[t++] = {ships[i].t, ctry};
            if (c2p[ctry] == 0) {
                distinct++;
            }
            c2p[ctry]++;
        }
        cty24[i] = distinct;
    }
    for (int i = 0; i < n; i++) {
        cout << cty24[i] << endl;
    }
    return 0;
}