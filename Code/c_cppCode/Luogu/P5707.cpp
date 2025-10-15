#include<iostream>
using namespace std;
const int EXT_TIME = 10;
int main() {
    int s, v;
    cin >> s >> v;
    int minutes = (24 + 8) * 60 - (s + v - 1)/ v - EXT_TIME;
    minutes = minutes > 24 * 60 ? minutes - 24 * 60 : minutes;
    int startHour = minutes / 60;
    int startMinutes = minutes % 60;
    printf("%02d:%02d", startHour,startMinutes);
    return 0;
}