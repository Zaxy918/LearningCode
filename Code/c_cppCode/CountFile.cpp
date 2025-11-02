#include <filesystem>
#include <iostream>
using namespace std;
namespace fs = std::filesystem;

int main() {
    string path = "../c_cppCode";

    int count = 0;

    try {
        for (const auto &entry : fs::recursive_directory_iterator(path)) {
            if (entry.is_regular_file() && entry.path().extension() == ".cpp") {
                count++;
            }
        }
        cout << "All cpps: " << count << endl;
    } catch (const fs::filesystem_error &e) {
        cerr << "Wrong" << e.what() << endl;
    }

    return 0;
}
