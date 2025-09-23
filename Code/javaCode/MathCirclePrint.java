public class MathCirclePrint {
    public static void main(String[] args) {
        int n = 5;
        int cnt = n * n;
        int[][] circle = new int[n][n];
        if (n % 2 == 1)
            circle[n / 2][n / 2] = 1;
        for (int i = n - 1; i >= n / 2; i--) {
            for (int j = i; j > n - i - 1; j--) {
                circle[n - i - 1][j] = cnt--;
            }
            for (int j = n - i - 1; j <= i - 1; j++) {
                circle[j][n - i - 1] = cnt--;
            }
            for (int j = n - i - 1; j <= i - 1; j++) {
                circle[i][j] = cnt--;
            }
            for (int j = i; j >= n - i; j--) {
                circle[j][i] = cnt--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(circle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
