#include <cctype>
#include <iostream>
using namespace std;

int p1, p2, p3;
string orgStr;
char pst, nxt;

int main() {
    cin >> p1 >> p2 >> p3;
    cin >> orgStr;
    if (orgStr.length() < 3) {
        cout << orgStr << endl;
    } else {
        pst = orgStr[0];
        nxt = orgStr[2];
        for (int i = 0; i < orgStr.length() - 1; i++) {
            if (orgStr[i] == '-') {
                if (i == 0) {
                    cout << orgStr[i];
                    continue;
                }
                pst = orgStr[i - 1];
                nxt = orgStr[i + 1];
                if (pst < nxt && (isalpha(pst) && isalpha(nxt) || isdigit(pst) && isdigit(nxt))) {
                    string gap;
                    for (int i = pst + 1; i < nxt; i++) {
                        for (int j = 0; j < p2; j++) {
                            gap += p1 == 1 ? (char)i : (p1 == 2 ? toupper((char)i) : '*');
                        }
                    }
                    if (p3 == 1) {
                        cout << gap;
                    } else {
                        for (int i = gap.length() - 1; i >= 0; i--) {
                            cout << gap[i];
                        }
                    }
                } else {
                    cout << orgStr[i];
                }
            } else {
                cout << orgStr[i];
            }
        }
        cout << orgStr[orgStr.length() - 1] << endl;
    }
}