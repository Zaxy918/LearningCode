#include <algorithm>
#include <iostream>
using namespace std;

const int END = 9;

int A, B, C;
int ans[END];
bool hasSlt;
bool vst[END + 1];

void dfs(int d) {
    if (d == END) {
        double n1 = ans[0] * 100 + ans[1] * 10 + ans[2];
        double n2 = ans[3] * 100 + ans[4] * 10 + ans[5];
        double n3 = ans[6] * 100 + ans[7] * 10 + ans[8];
        if (n1 / A == n2 / B && n2 / B == n3 / C && n1 / A == n3 / C) {
            hasSlt = true;
            cout << n1 << " " << n2 << " " << n3 << endl;
        }
        return;
    }
    for (int i = 1; i <= END; i++) {
        if (!vst[i]) {
            ans[d] = i;
            vst[i] = true;
            dfs(d + 1);
            vst[i] = false;
        }
    }
}

int main() {
    cin >> A >> B >> C;
    dfs(0);
    if (!hasSlt) cout << "No!!!";
    return 0;
}