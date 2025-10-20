#include <algorithm>
#include <iostream>
#include <map>
using namespace std;

struct People {
    string name;
    string pos;
    int cmt;
    int lev;
    int iptod;
};

const int MAX_N = 110;
map<string, int> POSITION;
int n, cnt, bzcnt;
People peos[MAX_N];
People bzs[3];

bool cmpCmt(People a, People b) {
    return a.cmt == b.cmt ? a.iptod < b.iptod : a.cmt > b.cmt;
}

bool cmp(People a, People b) {
    return POSITION[a.pos] == POSITION[b.pos] ? (a.lev == b.lev ? a.iptod < b.iptod : a.lev > b.lev) : POSITION[a.pos] < POSITION[b.pos];
}

int main() {
    POSITION["HuFa"] = 0;
    POSITION["ZhangLao"] = 1;
    POSITION["TangZhu"] = 2;
    POSITION["JingYing"] = 3;
    POSITION["BangZhong"] = 4;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string tmpName;
        string tmpPos;
        int tmpCmt;
        int tmpLev;
        cin >> tmpName >> tmpPos >> tmpCmt >> tmpLev;
        if (tmpPos == "BangZhu") {
            bzs[0] = {tmpName, tmpPos, tmpCmt, tmpLev, bzcnt};
            bzcnt++;
        } else if (tmpPos == "FuBangZhu") {
            if (bzcnt == 1) {
                bzs[1] = {tmpName, tmpPos, tmpCmt, tmpLev, 0};
                bzcnt++;
            } else {
                bzs[2] = {tmpName, tmpPos, tmpCmt, tmpLev, 0};
                bzcnt++;
            }
        } else {
            peos[cnt] = {tmpName, tmpPos, tmpCmt, tmpLev, cnt};
            cnt++;
        }
    }
    sort(peos, peos + cnt, cmpCmt);
    for (int i = 0; i < cnt; i++) {
        if (i < 2) {
            peos[i].pos = "HuFa";
        } else if (i < 6) {
            peos[i].pos = "ZhangLao";
        } else if (i < 13) {
            peos[i].pos = "TangZhu";
        } else if (i < 38) {
            peos[i].pos = "JingYing";
        } else {
            peos[i].pos = "BangZhong";
        }
    }
    sort(peos, peos + cnt, cmp);
    for (int i = 0; i < bzcnt; i++) {
        cout << bzs[i].name << " " << bzs[i].pos << " " << bzs[i].lev << endl;
    }
    for (int i = 0; i < cnt; i++) {
        cout << peos[i].name << " " << peos[i].pos << " " << peos[i].lev << endl;
    }
    return 0;
}