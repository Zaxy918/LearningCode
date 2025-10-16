#include <iostream>
#include <string>
using namespace std;

const int MAX_ROW = 401;
const int MAX_COL = 26;

char colGraph[MAX_ROW][MAX_COL];
int cnts[MAX_COL];
int maxCnt;
string line;
int n = 4;

void initColGraph() {
    for (int i = 0; i < MAX_ROW; i++) {
        for (int j = 0; j < MAX_COL; j++) {
            colGraph[i][j] = ' ';
        }
    }
    for (int i = 0; i < MAX_COL; i++) {
        colGraph[MAX_ROW - 1][i] = 'A' + i;
    }
}

int main() {
    initColGraph();
    while (n--) {
        getline(cin, line);
        for (char c : line) {
            if (isalpha(c)) {
                int cnt = ++cnts[c - 'A'];
                maxCnt = cnt > maxCnt ? cnt : maxCnt;
            }
        }
    }
    for (int i = 0; i < MAX_COL; i++) {
        for (int j = MAX_ROW - 2; j > MAX_ROW - 2 - cnts[i]; j--) {
            colGraph[j][i] = '*';
        }
    }
    for (int i = MAX_ROW - 1 - maxCnt; i < MAX_ROW; i++) {
        int last = MAX_COL - 1;
        if (i != MAX_ROW - 1) {
            for (int k = MAX_COL - 1; k >= 0; k--) {
                if (colGraph[i][k] == '*') {
                    last = k;
                    break;
                }
            }
        }
        for (int j = 0; j <= last; j++) {
            cout << colGraph[i][j];
            if (j != MAX_COL - 1)
                cout << " ";
        }
        cout << endl;
    }
    return 0;
}