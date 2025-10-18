#include <cmath>
#include <iostream>
#include <string>
using namespace std;

char inputs[25 * 2501];
int cnt;

void judgeWin(int base) {
    int w = 0, l = 0;
    for (int i = 0; i < cnt; i++) {
        inputs[i] == 'W' ? w++ : l++;
        if ((w >= base || l >= base) && abs(w - l) > 1) {
            printf("%d:%d\n", w, l);
            w = 0;
            l = 0;
        }
    }
    printf("%d:%d\n", w, l);
    return;
}

int main() {
    char c;
    while ((c = getchar()) && c != 'E') {
        if (c == '\r' || c == '\n') {
            continue;
        }
        inputs[cnt++] = c;
    }
    judgeWin(11);
    cout << endl;
    judgeWin(21);
    return 0;
}