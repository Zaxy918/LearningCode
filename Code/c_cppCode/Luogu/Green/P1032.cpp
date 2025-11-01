#include <iostream>
#include <map>
using namespace std;

const int MAX_R = 6;
const int MAX_S = 10;

string a, b;
string rules[MAX_R][2];
string q[MAX_R * MAX_S * 20000];
map<string, bool> vis;
int h, t;
int cnt, res;

int main() {
    cin >> a >> b;
    while (cin >> rules[cnt][0] >> rules[cnt][1]) cnt++;
    q[t++] = a;
    while (h < t && res < 10) {
        res++;
        int size = t - h;
        for (int i = 0; i < size; i++) {
            string cur = q[h++];
            for (int j = 0; j < cnt; j++) {
                int pos = cur.find(rules[j][0]);
                while (pos >= 0) {
                    string next = cur.substr(0, pos) + rules[j][1] + cur.substr(pos + rules[j][0].length());
                    if (next == b) {
                        cout << res;
                        return 0;
                    }
                    if (!vis[next]) {
                        q[t++] = next;
                        vis[next] = true;
                    }
                    pos = cur.find(rules[j][0], pos + 1);
                }
            }
        }
    }
    cout << "NO ANSWER!";
    return 0;
}