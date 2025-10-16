#include <iostream>
using namespace std;
int N;
int block[39][39];
int row, col;
int main() {
    cin >> N;
    row = 0;
    col = N / 2;
    for (int K = 1; K <= N * N; K++) {
        block[row][col] = K;
        if (row == 0 && col != N - 1) {
            row = N - 1;
            col++;
        } else if (col == N - 1 && row != 0) {
            col = 0;
            row--;
        } else if (row == 0 && col == N - 1) {
            row++;
        } else if (row != 0 && col != N - 1) {
            if (block[row - 1][col + 1] == 0) {
                row--;
                col++;
            } else {
                row++;
            }
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            printf("%d ", block[i][j]);
        }
        printf("\n");
    }
}