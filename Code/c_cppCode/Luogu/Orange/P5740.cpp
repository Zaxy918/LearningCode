#include <iostream>
#include <vector>
using namespace std;

struct Student {
    string name;
    int cns;
    int math;
    int eng;
};

int N;
int cnt;
int maxCnt;
int maxScr;

int main() {
    cin >> N;
    vector<Student> stus(N);
    for (int i = 0; i < N; i++) {
        string name;
        int cns, math, eng;
        cin >> name >> cns >> math >> eng;
        int sum = cns + math + eng;
        maxCnt = sum > maxScr ? cnt : maxCnt;
        maxScr = max(sum, maxScr);
        stus[cnt++] = {name, cns, math, eng};
    }
    Student topStu = stus[maxCnt];
    cout << topStu.name << " " << topStu.cns << " " << topStu.math << " " << topStu.eng;
    return 0;
}