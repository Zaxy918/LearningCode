#include <climits>
#include <iostream>
using namespace std;

const int ORIENT_X[4] = {-1, 0, 1, 0};
const int ORIENT_Y[4] = {0, 1, 0, -1};
const int MAP_SIZE = 10;

char maze[MAP_SIZE + 2][MAP_SIZE + 2];
int oriC, oriF;
int xC, yC, xF, yF;
int minutes;

int main() {
    for (int i = 1; i <= MAP_SIZE; i++) {
        for (int j = 1; j <= MAP_SIZE; j++) {
            cin >> maze[i][j];
            if (maze[i][j] == 'C') {
                maze[i][j] = '.';
                xC = i;
                yC = j;
            } else if (maze[i][j] == 'F') {
                maze[i][j] = '.';
                xF = i;
                yF = j;
            }
        }
    }
    while (true) {
        minutes++;
        if (minutes == 10000000) {
            cout << 0 << endl;
            break;
        }
        int curXC = xC + ORIENT_X[oriC % 4];
        int curYC = yC + ORIENT_Y[oriC % 4];
        int curXF = xF + ORIENT_X[oriF % 4];
        int curYF = yF + ORIENT_Y[oriF % 4];
        maze[curXC][curYC] == '.' ? xC = curXC, yC = curYC : oriC++;
        maze[curXF][curYF] == '.' ? xF = curXF, yF = curYF : oriF++;
        if (xC == xF && yC == yF) {
            cout << minutes << endl;
            break;
        }
    }
    return 0;
}