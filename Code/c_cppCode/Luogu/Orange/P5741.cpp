#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

struct Student {
    string name;
    int cns;
    int math;
    int eng;
    int sum;
};

int N;

bool isPat(Student a, Student b) {
    return abs(a.cns - b.cns) <= 5 && abs(a.math - b.math) <= 5 && abs(a.eng - b.eng) <= 5 && abs(a.sum - b.sum) <= 10;
}

int main() {
    cin >> N;
    vector<Student> stus(N);
    for (int i = 0; i < N; i++) {
        string name;
        int cns, math, eng;
        cin >> name >> cns >> math >> eng;
        int sum = cns + math + eng;
        stus[i] = {name, cns, math, eng, sum};
    }
    for (int i = 0; i < N; i++) {
        Student stui = stus[i];
        for (int j = i + 1; j < N; j++) {
            Student stuj = stus[j];
            if (isPat(stui, stuj)) {
                cout << stui.name << " " << stuj.name << endl;
            }
        }
    }
    return 0;
}