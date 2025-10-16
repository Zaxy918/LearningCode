#include <iostream>
using namespace std;

const int MAX_N = 10;

int n;
char origin[MAX_N][MAX_N];
char turned[MAX_N][MAX_N];

bool t90() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (origin[i][j] != turned[j][n - 1 - i])
                return false;
        }
    }
    return true;
}

bool t180() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (origin[i][j] != turned[n - 1 - i][n - 1 - j])
                return false;
        }
    }
    return true;
}

bool t270() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (origin[i][j] != turned[n - 1 - j][i]) {
                return false;
            }
        }
    }
    return true;
}

bool flip() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (origin[i][j] != turned[i][n - 1 - j])
                return false;
        }
    }
    return true;
}

bool conbine() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int flipx = i;
            int flipy = n - 1 - j;
            int t90x = flipy;
            int t90y = n - 1 - flipx;
            int t180x = n - 1 - flipx;
            int t180y = n - 1 - flipy;
            int t270x = n - 1 - flipy;
            int t270y = flipx;
            if (origin[i][j] != turned[t90x][t90y] && origin[i][j] != turned[t180x][t180y] && origin[i][j] != turned[t270x][t270y]) {
                return false;
            }
        }
    }
    return true;
}

bool keep() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (origin[i][j] != turned[i][j])
                return false;
        }
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            char c;
            cin >> c;
            origin[i][j] = c;
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            char c;
            cin >> c;
            turned[i][j] = c;
        }
    }

    if (t90()) {
        cout << 1;
    } else if (t180()) {
        cout << 2;
    } else if (t270()) {
        cout << 3;
    } else if (flip()) {
        cout << 4;
    } else if (conbine()) {
        cout << 5;
    } else if (keep()) {
        cout << 6;
    } else {
        cout << 7;
    }
}