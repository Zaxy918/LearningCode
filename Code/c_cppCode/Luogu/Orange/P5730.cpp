#include <iostream>
using namespace std;

const int MAX_COL = 4 * 100;
const int MAX_ROW = 5;

int n;
string num;
char screen[MAX_ROW][MAX_COL];
int startCol;

void fiilDots() {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < n * 4; j++) {
            screen[i][j] = '.';
        }
    }
}

int main() {
    cin >> n;
    cin >> num;
    fiilDots();
    for (char c : num) {
        switch (c) {
        case '0': {
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (!(j == startCol + 1 && (i == 1 || i == 2 || i == 3))) {
                        screen[i][j] = 'X';
                    }
                }
            }
        } break;
        case '1': {
            for (int i = 0; i < 5; i++) {
                screen[i][startCol + 2] = 'X';
            }
        } break;
        case '2': {
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (!((i == 1 && (j == startCol || j == startCol + 1)) || (i == 3 && (j == startCol + 1 || j == startCol + 2)))) {
                        screen[i][j] = 'X';
                    }
                }
            }
        } break;
        case '3': {
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (!((i == 1 && (j == startCol || j == startCol + 1)) || (i == 3 && (j == startCol || j == startCol + 1)))) {
                        screen[i][j] = 'X';
                    }
                }
            }
        } break;
        case '4': {
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (!((j == startCol && (i == 3 || i == 4)) || (j == startCol + 1 && (i == 0 || i == 1 || i == 3 || i == 4)))) {
                        screen[i][j] = 'X';
                    }
                }
            }
        } break;
        case '5': {
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (!((i == 1 && (j == startCol + 1 || j == startCol + 2)) || (i == 3 && (j == startCol || j == startCol + 1)))) {
                        screen[i][j] = 'X';
                    }
                }
            }
        } break;
        case '6': {
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (!((i == 1 && (j == startCol + 1 || j == startCol + 2)) || (i == 3 && j == startCol + 1))) {
                        screen[i][j] = 'X';
                    }
                }
            }
        } break;
        case '7': {
            for (int i = startCol; i < startCol + 3; i++) {
                screen[0][i] = 'X';
            }
            for (int i = 0; i < MAX_ROW; i++) {
                screen[i][startCol + 2] = 'X';
            }
        } break;
        case '8': {
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (!((i == 1 && j == startCol + 1) || (i == 3 && j == startCol + 1))) {
                        screen[i][j] = 'X';
                    }
                }
            }
        } break;
        case '9': {
            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (!((i == 1 && j == startCol + 1) || (i == 3 && (j == startCol || j == startCol + 1)))) {
                        screen[i][j] = 'X';
                    }
                }
            }
        } break;
        }
        startCol += 4;
    }
    for (int i = 0; i < MAX_ROW; i++) {
        for (int j = 0; j < n * 4 - 1; j++) {
            cout << screen[i][j];
        }
        cout << endl;
    }
}