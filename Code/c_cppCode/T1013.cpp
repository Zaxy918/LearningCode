#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;

int main() {
    string sentence;
    cout << "请输入一个句子: ";
    getline(cin, sentence);  // 读取整行，包括空格
    
    // 将句子转换为小写
    transform(sentence.begin(), sentence.end(), sentence.begin(), ::tolower);
    
    // 使用字符串流分割单词
    stringstream ss(sentence);
    string word;
    vector<string> words;
    
    // 逐个读取单词
    while (ss >> word) {
        // 翻转单词
        reverse(word.begin(), word.end());
        words.push_back(word);
    }
    
    // 输出结果
    cout << "处理后的句子: ";
    for (int i = 0; i < words.size(); i++) {
        cout << words[i];
        if (i < words.size() - 1) {
            cout << " ";  // 单词之间加空格
        }
    }
    cout << endl;
    
    return 0;
}