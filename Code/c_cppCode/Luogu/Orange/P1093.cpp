#include <algorithm>
#include <iostream>
using namespace std;

const int MAX_N = 301;

struct Student {
    int sum;
    int cns;
    int math;
    int eng;
    int id;
};

int n, cnt;
Student stus[MAX_N];

int main() {
    ios::sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int cns, math, eng, sum;
        cin >> cns >> math >> eng;
        sum = cns + math + eng;
        stus[i] = {sum, cns, math, eng, ++cnt};
    }
    sort(stus, stus + cnt, [](Student a, Student b) { return a.sum == b.sum ? a.cns == b.cns ? a.id < b.id : a.cns > b.cns : a.sum > b.sum; });
    for_each(stus, stus + 5, [](Student s) { cout << s.id << " " << s.sum << endl; });
    return 0;
}